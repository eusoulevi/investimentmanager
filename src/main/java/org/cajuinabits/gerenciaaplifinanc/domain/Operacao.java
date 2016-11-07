
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.sql.Timestamp;

/**
 *
 * @author levi.soares
 */
public interface Operacao {
    public Double getCorretagem();
    public Double getEmolumentos();
    public void setCota(Cota cota);
    public Cota getCota();
    public void setQuantidade(int quant);
    public int getQuantidade();
    public Double getImpostos();
    public void setDataHora(Timestamp c);
    public Timestamp getDataHora();
    public boolean isStatus();
}
