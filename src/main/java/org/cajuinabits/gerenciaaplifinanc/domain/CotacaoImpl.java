
package org.cajuinabits.gerenciaaplifinanc.domain;

import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.sql.Timestamp;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;

/**
 *
 * @author levi.soares
 */
@Entity(name = "cotacoes")
public class CotacaoImpl implements Cotacao, Comparable<Cotacao>, Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCotacao;
    
    @ManyToOne(targetEntity = CotaImpl.class)
    @JoinColumn(name = "idCota")
    private Cota cota;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Inject
    private Timestamp datetime;
    
    private Double valor;
    
    @Inject
    private Logger logger;
    
    public CotacaoImpl() {
    }
    
    public CotacaoImpl(Double valor) {        
        this.setValor(valor);
    }

    public CotacaoImpl(Double valor, Timestamp t) {
        if (t==null) {
            try {
                sleep(1);
            } catch (InterruptedException ex) {
                logger.error("Problemas com o relógio do sistema", ex);
            }
        }
        this.datetime = t;
        this.valor = valor;
    }

    @Override
    public Long getId() {
        return this.idCotacao;
    }

    @Override
    public void setId(Long id) {
        this.idCotacao = id;
    }        

    @Override
    public Timestamp getDatetime() {
        return this.datetime;
    }

    @Override
    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public Double getValor() {
        return this.valor;
    }

    @Override
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idCotacao);
        hash = 79 * hash + Objects.hashCode(this.datetime);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CotacaoImpl other = (CotacaoImpl) obj;
        if (!Objects.equals(this.idCotacao, other.getId())) {
            return false;
        }
        if (!Objects.equals(this.cota, other.getCota())) {
            return false;
        }
        if (!Objects.equals(this.datetime, other.getDatetime())) {
            return false;
        }
        if (!Objects.equals(this.valor, other.getValor())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cotacao{" + "id=" + idCotacao + ", datetime=" + datetime + ", valor=" + getValor() + '}';
    }

    @Override
    public int compareTo(Cotacao o) {
        return this.valor.compareTo( o.getValor());
    }

    @Override
    public Cota getCota() {
        return this.cota;
    }

    @Override
    public void setCota(Cota cota) {
        this.cota = cota;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
        
}
