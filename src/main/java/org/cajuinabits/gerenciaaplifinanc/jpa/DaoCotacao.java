
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.cajuinabits.gerenciaaplifinanc.domain.CotacaoImpl;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;

/**
 *
 * @author User
 */
public class DaoCotacao implements Serializable {
    private static final long serialVersionUID = 28065345642800000L;
    
    @Inject
    private EntityManager em;

    public void create(CotacaoImpl cotacao) {
            em.getTransaction().begin();
            em.persist(cotacao);
            em.getTransaction().commit();
    }

    public void edit(CotacaoImpl cotacao) throws NonexistentEntityException, Exception {
        try {
            em.getTransaction().begin();
            cotacao = em.merge(cotacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cotacao.getId();
                if (findCotacao(id) == null) {
                    throw new NonexistentEntityException("A cotacao com id " + id + " nao existe.");
                }
            }
            throw ex;
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        em.getTransaction().begin();
        CotacaoImpl cotacao;
        try {
            cotacao = em.getReference(CotacaoImpl.class, id);
            cotacao.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("A cotacao com id " + id + " nao existe.", enfe);
        }
        em.remove(cotacao);
        em.getTransaction().commit();        
    }

    public List<CotacaoImpl> findCotacaoEntities() {
        return findCotacaoEntities(true, -1, -1);
    }

    public List<CotacaoImpl> findCotacaoEntities(int maxResults, int firstResult) {
        return findCotacaoEntities(false, maxResults, firstResult);
    }

    private List<CotacaoImpl> findCotacaoEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(CotacaoImpl.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();         
    }

    public CotacaoImpl findCotacao(Long id) {
        return em.find(CotacaoImpl.class, id);      
    }

    public int getCotacaoCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<CotacaoImpl> rt = cq.from(CotacaoImpl.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
