
package modelo;

import java.util.Objects;

/**
 *
 * @author erni
 */
public class Tarjeta {
    private long idtarjeta;
    private String fecharegistro;

    
    public Tarjeta( String fecharegistro) {
       
        this.fecharegistro = fecharegistro;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.idtarjeta ^ (this.idtarjeta >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fecharegistro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarjeta other = (Tarjeta) obj;
        if (this.idtarjeta != other.idtarjeta) {
            return false;
        }
        if (!Objects.equals(this.fecharegistro, other.fecharegistro)) {
            return false;
        }
        return true;
    }

    
 
    @Override
    public String toString() {
        return "Tarjeta{" + "idtarjeta=" + idtarjeta + ", fecharegistro=" + fecharegistro + '}';
    }

    public long getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(long idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

   
  
}
