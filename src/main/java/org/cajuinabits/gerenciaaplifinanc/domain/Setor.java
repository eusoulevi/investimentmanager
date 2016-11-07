
package org.cajuinabits.gerenciaaplifinanc.domain;

/**
 *
 * @author levi.soares
 */
public enum Setor {
    
    AGROPECUARIA("Agropecuária"),
    AGUA("Água e Saneamento"),
    GAS_SANEAMENTO("Gás e Saneamento"),
    ALIMENTOS_PROCESSADOS("Alimentos Processados"),
    BANCOS("Bancos"),
    CARNES_E_DERIVADOS("Carnes e Derivados"),
    CONSTRUCAO_CIVIL_E_INTERMEDIACAO("Construção civil e intermediação"),
    CONSTRUCAO_PESADA_E_ENGENHARIA("Construção pesada e engenharia"),
    ENERGIA_ELETRICA("Energia Elétrica"),
    EQUIPAMENTOS("Equipamentos"),
    MAQUINAS_E_PECAS("Máquinas e Peças"),
    HOLDINGS("Holdings"),
    HOTELARIA_E_RESTAURANTES("Hotelaria e restaurantes"),
    IMOVEIS_COMERCIAIS_SHOPPINGS("Imóveis comerciais e shoppings"),
    INDUSTRIAS_ALIMENTOS("Indústrias de alimentos"),
    INDUSTRIAS_GERAL("Indústrias em Geral"),
    MATERIAIS_DIVERSOS("Materiais diversos"),
    MINERACAO("Mineração"),
    LAZER_E_EVENTOS("lazer e eventos"),
    CELULOSE_MADEIRA("Celulose e Madeira"),
    PETROLEO("Petróleo"),
    GAS_COMBUSTIVEIS("Gás e Combustíveis"),
    QUIMICA_PETROQUIMICA("Química e Petroquímica"),
    ROUPAS("Roupas"),
    CALCADOS_E_ACESSORIOS("Calçados e Acessórios"),
    SERVICOS_DIVERSOS("Servicos Diversos"),
    FINANCEIRO("Serviços Financeiros"),
    EDUCACAO("Educação"),
    SAUDE("saúde"),
    SEGUROS("Seguros"),
    TRANSPORTE("transporte"),
    SIDERURGIA("Siderurgia e metalurgia"),
    TECNOLOGIA("Tecnologia da Informação"),
    TELECOMUNICACOES("Telecomunicações"),
    TEXTEL("Têxtil"),
    UTILIDADES_DOMESTICAS("Utilidades Domésticas"),
    VAREJO("Varejo")
;
    
    private String opcao;
    
    Setor(String valorOpcao){
        this.opcao = valorOpcao; 
    }
    
    public String getOpcao() {
        return this.opcao; 
    }
}

