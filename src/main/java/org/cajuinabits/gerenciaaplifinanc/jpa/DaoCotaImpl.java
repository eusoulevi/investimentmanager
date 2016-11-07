
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.cajuinabits.gerenciaaplifinanc.domain.Cota;
import org.cajuinabits.gerenciaaplifinanc.domain.CotaImpl;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.slf4j.Logger;

/**
 *
 * @author levi.soares
 */
public class DaoCotaImpl implements Dao, Serializable {
    
    private static final long serialVersionUID = 28065345642800011L;
    
    @Inject
    private Logger logger;
    
    @Inject
    private EntityManager em;
    
    public DaoCotaImpl() {    
    }
    
    @Override
    public void create(Cota cota) {
        logger.info("Verificando se EntityManager está instanciada: " + em);
        em.getTransaction().begin();
        em.persist(cota);
        em.getTransaction().commit();
    }

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     */
    @Override
    public void destroy(long id) throws NonexistentEntityException {
        em.getTransaction().begin();
        CotaImpl cotaImpl;
        try {
            cotaImpl = em.getReference(CotaImpl.class, id);
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("A cota com id " + id + " nao existe.", enfe);
        }
        em.remove(cotaImpl);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Cota cota) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            cota = em.merge(cota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String sigla = cota.getSigla();
                if (find(sigla, cota.getClass()) == null) {
                    throw new NonexistentEntityException("A cota com sigla " + sigla + " nao existe.");
                }
            }
            throw ex;
        }
    }
    
    @Override
    public Cota find(String sigla, Class c) {
        Object result = null;
        try {
            Query query = em.createQuery("from as " + c.getCanonicalName() + " where c.sigla = :sigla");
            query.setParameter("sigla", sigla);
            result = query.getSingleResult();
            return (Cota)result;
        } catch ( NoResultException nre ) {
            return null;
        }
    }

    @Override
    public Cota find(long id) {
        return (Cota) em.find(CotaImpl.class, id);
    }
        
    @Override
    public List list(Class entityClass) {
        return list(true, -1, -1,entityClass);
    }

    @Override
    public List list(int maxResults, int firstResult, Class entityClass) {
        return list(false, maxResults, firstResult,entityClass);
    }
    
    private List list(boolean all, int maxResults, int firstResult, Class entityClass) {
        List list = null;
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        list = q.getResultList();
        return list;
    }   

    @Override
    public int getCount(Class entityClass) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<CotaImpl> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public Logger getLogger() {
        return this.logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.em = manager;
    }

}