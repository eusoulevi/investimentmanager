package org.cajuinabits.gerenciaaplifinanc.domain;

import java.util.List;
import javax.persistence.Entity;
/**
 * @author levi.soares
 */
@Entity(name = "fiis")
public class FiiImpl extends CotaImpl implements Fii {
    private String administrador;
    private List<String> ativos;
        
    @Override
    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    @Override
    public String getAdministrador() {
        return administrador;
    }

    @Override
    public void addAtivos(String ativos) {
        this.ativos.add(ativos);
    }

    @Override
    public void removeAtivos(String ativo) {
        this.ativos.remove(ativo);
    }

    @Override
    public List<String> getAtivos() {
        return ativos;
    }
}
