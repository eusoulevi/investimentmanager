package org.cajuinabits.gerenciaaplifinanc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author levi.soares
 */
@Entity(name = "investimentos")
public class InvestimentoImpl implements Investimento {

    @Id
    @GeneratedValue
    private long id;    
    
    private Double capitalInvestido;
    
    @OneToMany
    private Operacao operacao;
    
    public InvestimentoImpl() {}
    
    public InvestimentoImpl(Operacao o) {
        this.operacao = o;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Double getCapitalInvestido() {
        this.capitalInvestido = operacao.getCota().getValor(operacao.getDataHora())
                * operacao.getQuantidade();
        return this.capitalInvestido;
    }

    @Override
    public Double ganhoRealValorizacao() {
        Cota cota = operacao.getCota();
        Double valorAtual = cota.getValorAtual();
        int quant = operacao.getQuantidade();
        Double totalAtual = valorAtual * quant;
        Double ganho = totalAtual - getTotalInvestido();
        return ganho;
    }

    @Override
    public Double getTotalInvestido() {
        Double totalInvestido = null;
        totalInvestido = getCapitalInvestido() - operacao.getCorretagem() - operacao.getEmolumentos() 
                - operacao.getImpostos();
        return totalInvestido;
    }

    @Override
    public Double juros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPeriodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double ganhoReal(Double inflacao) {
        Double ganhoReal = null;
        ganhoReal = ganhoRealValorizacao() - this.operacao.getCorretagem() - this.operacao.getEmolumentos()
                - this.operacao.getImpostos();
        return ganhoReal;
    }

    public Operacao getOperacao() {
        return this.operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    @Override
    public Double getCustoInvestimento() {
        Double custos = operacao.getCorretagem() + operacao.getEmolumentos() +
                operacao.getImpostos();
        return custos;
    }
    
}
