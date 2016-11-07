
package org.cajuinabits.gerenciaaplifinanc.util;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author levi.soares
 */
@ApplicationScoped
public class Produtor {
    
//    public Produtor() {
//    }
    
    /**
     *
     * @param injectionPoint
     * @return
     */
    @Produces
    public Logger createLogger( InjectionPoint injectionPoint ) {        
//        Class classe = injectionPoint.getMember().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        return logger;
    }

    /**
     *
     */
//    @Produces @Named("criaLista")
    @Produces @Named
    public List criaLista() {
        return new ArrayList<>();
    }
    
    @Produces
    public Timestamp createCalendar() {
        return  new Timestamp(System.currentTimeMillis());     
    }

}
