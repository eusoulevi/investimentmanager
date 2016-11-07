package org.cajuinabits.gerenciaaplifinanc.domain;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author levi.soares
 */
public interface Cota {
    public void setSigla(String name);
    public String getSigla();
    public void setDescricao(String desc);
    public String getDescricao();
     /**
     * Retorna a última cotação registrada
     * @return
     */
    public Double getValorAtual();
    public Cotacao getCotacaoAtual();
    public Double getValor(Timestamp datetime);
    public void setTipo(String tipo);
    public String getTipo();
    public List<Cotacao> getHistorico();
    public void addCotacao(Cotacao c);
    public Cotacao getCotacaoMin();    
    public Cotacao getCotacaoMax();    

}