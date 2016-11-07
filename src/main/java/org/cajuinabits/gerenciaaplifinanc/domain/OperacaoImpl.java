
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author levi.soares
 */
@Entity(name = "operacoes")
public class OperacaoImpl implements Operacao{
    
    @Id
    @GeneratedValue
    private Long id;    
    
    private Double corretagem;
    
    private Double emolumentos;
    
    private Double impostos;
    
    @NotNull
    private int quantidade;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Cota cota;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dataHora;
    
    private boolean concretizada;
    
    public OperacaoImpl() {}

    public OperacaoImpl(Double corretagem, Double emolumentos, Double impostos) {
        this.corretagem = corretagem;
        this.emolumentos = emolumentos;
        this.impostos = impostos;
    }
    
    public OperacaoImpl(Double corretagem, Double emolumentos, Double impostos,Cota cota,int quant) {
        this(corretagem, emolumentos, impostos);
        this.cota = cota;
        this.quantidade = quant;
        this.dataHora = cota.getCotacaoAtual().getDatetime();
    }
    
    public void setCorretagem(Double corretagem) {
        this.corretagem = corretagem;
    }

    @Override
    public Double getCorretagem() {
        return this.corretagem;
    }

    public void setEmolumentos(Double emolumentos) {
        this.emolumentos = emolumentos;
    }

    @Override
    public Double getEmolumentos() {
        return this.emolumentos;
    }

    @Override
    public void setQuantidade(int quant) {
        this.quantidade = quant;
    }

    @Override
    public int getQuantidade() {
        return this.quantidade;
    }

    @Override
    public void setDataHora(Timestamp c) {
        this.dataHora = c;
    }
    
    @Override
    public Timestamp getDataHora() {
        return this.dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getImpostos() {
        return impostos;
    }

    public void setImpostos(Double impostos) {
        this.impostos = impostos;
    }

    @Override
    public Cota getCota() {
        return this.cota;
    }

    public void setCota(Cota cota) {
        this.cota = cota;
        this.dataHora = cota.getCotacaoAtual().getDatetime();
    }

    @Override
    public boolean isStatus() {
        return concretizada;
    }

}
