
package org.cajuinabits.gerenciaaplifinanc.jpa;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.domain.Cota;
import org.cajuinabits.gerenciaaplifinanc.domain.Stock;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;

import org.slf4j.Logger;

/**
 import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
*
 * @author levi.soares
 */
public class DaoAcaoImpl implements DaoAcao, Serializable {
    
    private static final long serialVersionUID = 28065345642899881L;

    @Inject
    private Dao dao;
    
    @Inject @Named("criaLista")
    private List acoes;
    
    @Inject
    private Logger logger;
       
    public DaoAcaoImpl() {
    }

    @Override
    public void create(Acao acao) {
        dao.create(acao);
    }

    @Override
    public void destroy(long id) throws NonexistentEntityException {
        try {
            dao.destroy(id);
        } catch (org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException ex) {
            logger.error("Id não existe ou não encontrado", ex);
        }
    }

    @Override
    public void edit(Acao acao) throws NonexistentEntityException, Exception {
        dao.edit(acao);
    }

    @Override
    public Acao find(String sigla) {
        return (Acao) dao.find(sigla,Acao.class);
    }

    @Override
    public Acao find(long id) {
        return (Acao) dao.find(id);
    }

    @Override
    public List<Acao> list() {
        List<Cota> list = dao.list(Acao.class);
        for (Iterator<Cota> iterator = list.iterator(); iterator.hasNext();) {
                Cota next = (Stock) iterator.next();
                this.acoes.add(next);
        }                
        return acoes;
    }

    @Override
    public List<Acao> list(int maxResults, int firstResult) {
        List retorno = dao.list(maxResults, firstResult, Acao.class);
        return (List<Acao>) retorno;
    }

    @Override
    public int getCount() {
        return dao.getCount(Acao.class);
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Dao getDao() {
        return this.dao;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
       
}
