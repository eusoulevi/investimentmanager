
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.util.List;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;

/**
 *
 * @author levi.soares
 */
public interface DaoAcao {
    
    public void create(Acao acao);

    public void destroy(long id) throws NonexistentEntityException;

    public void edit(Acao acao) throws NonexistentEntityException, Exception;

    public Acao find(String sigla);
    
    public Acao find(long id);

    public List<Acao> list();

    public List<Acao> list(int maxResults, int firstResult);

    public int getCount();
}
