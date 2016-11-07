
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.sql.Timestamp;

/**
 *
 * @author levi.soares
 */

public interface Cotacao extends Comparable<Cotacao>{    

    public Long getId();
    public Cota getCota();
    public void setCota(Cota cota);
    public void setId(Long id);        
    public Timestamp getDatetime();
    public void setDatetime(Timestamp datetime);
    public Double getValor();
    public void setValor(Double valor);
}
