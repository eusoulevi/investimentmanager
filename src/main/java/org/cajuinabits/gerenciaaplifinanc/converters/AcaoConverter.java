
package org.cajuinabits.gerenciaaplifinanc.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.domain.Acao;
import org.cajuinabits.gerenciaaplifinanc.jpa.DaoAcao;

/**
 *
 * @author levi.soares
 */
@FacesConverter(forClass = Acao.class)
public class AcaoConverter implements Converter {
    @Inject
    private DaoAcao daoAcao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.isEmpty()) return null;
        
        Acao acao = null;
        String[] values = string.split("-");
        Long decode = Long.decode(values[1]);
        long id = decode.longValue();            
        acao = daoAcao.find(id);
        return acao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Acao acao = (Acao) o;        
        return acao.getSigla();
    }

    public DaoAcao getDaoAcao() {
        return daoAcao;
    }

    public void setDaoAcao(DaoAcao daoAcao) {
        this.daoAcao = daoAcao;
    }
    
}
