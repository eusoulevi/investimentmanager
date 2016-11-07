
package org.cajuinabits.gerenciaaplifinanc.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.domain.Cotacao;
import org.cajuinabits.gerenciaaplifinanc.exceptions.NonexistentEntityException;
import org.cajuinabits.gerenciaaplifinanc.jpa.DaoAcao;
import org.slf4j.Logger;

/**
 *
 * @author levi.soares
 */
@ManagedBean
@RequestScoped
public class AcaoManagedBean {

    @Inject
    private DaoAcao dao;
    @Inject
    private Acao acao;
    @Inject
    private Logger logger;
    @Inject
    private Cotacao cotacao;

    /**
     * Creates a new instance of AcaoManagedBean
     */
    public AcaoManagedBean() {
    }
    
    public void criar() {
        this.acao.addCotacao(this.getCotacao());
        try {
            dao.create(acao);
        } catch (Exception ex) {
            logger.error("Erro ao criar a ação no método dao.create", ex);
        }
    }
    
    public void deletar() throws NonexistentEntityException {
        try {
            dao.destroy(acao.getIdCota());
        } catch (NonexistentEntityException ex) {
            logger.error("Erro ao deletar: método destroy", ex);
        }
    }

    public Acao getAcao() {
        return this.acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Cotacao getCotacao() {
        return this.cotacao;
    }

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }
    
}
