
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.util.List;

/**
 *
 * @author levi.soares
 */
public interface Fii {

    void addAtivos(String ativos);

    String getAdministrador();

    List<String> getAtivos();

    void removeAtivos(String ativo);

    void setAdministrador(String administrador);
    
}
