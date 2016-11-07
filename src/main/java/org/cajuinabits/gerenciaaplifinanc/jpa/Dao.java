
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.cajuinabits.gerenciaaplifinanc.domain.Cota;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;

/**
 *
 * @author levi.soares
 */
public interface Dao {

    public void create(Cota cota);

    public void destroy(long id) throws NonexistentEntityException;

    public void edit(Cota cota) throws NonexistentEntityException, Exception;

    public Cota find(String sigla, Class c);
    
    public Cota find(long id);

    public List<Cota> list(Class c);

    public List<Cota> list(int maxResults, int firstResult, Class c);

    public int getCount(Class c);

    public EntityManager getEntityManager();
    
    public void setEntityManager(EntityManager manager);    
    
}
