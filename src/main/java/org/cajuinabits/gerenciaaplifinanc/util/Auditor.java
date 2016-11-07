
package org.cajuinabits.gerenciaaplifinanc.util;

import javax.annotation.Priority;
import javax.interceptor.Interceptor;
import org.cajuinabits.gerenciaaplifinanc.interceptors.Auditavel;

/**
 *
 * @author levi.soares
 */
@Auditavel
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class Auditor {
    
}
