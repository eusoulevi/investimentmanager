package org.cajuinabits.gerenciaaplifinanc.domain;

/**
 *
 * @author levi.soares
 */
import javax.persistence.Entity;

@Entity(name = "acoes")
public class Acao extends CotaImpl implements Stock {
    
    private Setor setor;
    
    public Acao () {}
    
    public Acao(Cotacao c) {
        this.addCotacao(c);
    }
    
    @Override
    public Setor getSetor() {
        return this.setor;
    }
    
    @Override
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

}
