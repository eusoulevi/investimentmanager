package org.cajuinabits.gerenciaaplifinanc.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.slf4j.Logger;

/**
 *
 * @author levi.soares
 */
public class EntityConverter implements Converter {
    
    @Inject
    private Logger logger;

    @Inject
    private EntityManager em;
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if(object == null) return null;
        try {
            Class<?> classe = object.getClass();
            Long id = (Long) classe.getMethod("getId").invoke(object);
            Double valor = (Double) classe.getMethod("getValor").invoke(object);
            return classe.getName() + "-" + id;
        } catch (Exception e) {
            logger.error("Erro ao converter entidade em String", e);
            return null;
        }
    }
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if(string == null || string.isEmpty()) return null;

        try {
            String[] values = string.split("-");
            return em.find(Class.forName(values[0]), Long.valueOf(values[1]));
        } catch (Exception e) {
            logger.error("Erro ao converter String em entidade", e);
            return null;
        }
    }
    
    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
