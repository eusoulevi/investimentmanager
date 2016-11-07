
package org.cajuinabits.gerenciaaplifinanc.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.cajuinabits.gerenciaaplifinanc.domain.Cotacao;
import org.cajuinabits.gerenciaaplifinanc.jpa.DaoCotacao;

/**
 *
 * @author levi.soares
 */
@FacesConverter(forClass = CotacaoConverter.class)
public class CotacaoConverter implements Converter {
    @Inject
    private DaoCotacao dao;
    @Inject
    private Cotacao cotacao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String[] values = string.split("-");
        Long decode = Long.decode(values[1]);
        long id = decode.longValue();            
        cotacao = dao.findCotacao(id);
        return cotacao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Cotacao cotacao = (Cotacao) o;
        return cotacao.getValor().toString();
    }

    public DaoCotacao getDao() {
        return dao;
    }

    public void setDao(DaoCotacao dao) {
        this.dao = dao;
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }
    
}
