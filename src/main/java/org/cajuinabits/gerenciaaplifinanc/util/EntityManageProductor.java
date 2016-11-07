
package org.cajuinabits.gerenciaaplifinanc.util;

import javax.ejb.PrePassivate;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author levi
 */
@ApplicationScoped
public class EntityManageProductor {    
    private static final String PERSISTENCE_UNIT_NAME = "default";
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            
    @PrePassivate
    public void finalizar() {
        emf.close();
    }    
    
    @Produces @RequestScoped
    public EntityManager create() {
        return emf.createEntityManager();
    }
    
    public void fechaEntityManager(@Disposes EntityManager entityManager) {
        entityManager.close();
    }        
}