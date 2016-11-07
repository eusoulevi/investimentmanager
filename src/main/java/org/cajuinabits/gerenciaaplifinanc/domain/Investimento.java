
package org.cajuinabits.gerenciaaplifinanc.domain;

/**
 *
 * @author levi.soares
 */
public interface Investimento {
    
    public Double getCapitalInvestido();
    
    public Double getCustoInvestimento();
    
    public Double ganhoRealValorizacao();
    /*
     * Retorna o valor do investimento real (Capital investido + impostos, corretagem e emolumentos)
    */
    public Double getTotalInvestido();
    
    public Double juros();
    
    /*
     * Retorna o número de dias em que o capital ficou investido
    */
    public int getPeriodo();
    
    /*
     * Retorna o ganho real da aplicacao (juros - inflacao)
    */    
    public Double ganhoReal(Double inflacao);
    
}
