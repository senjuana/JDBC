
package modelo;

import java.util.Objects;

/**
 *
 * @author erni
 */
public class Recaudadora {
    private long no_recau;
    private String domicilio;
    private String telefono;

    public Recaudadora( String domicilio, String telefono) {
        this.no_recau = no_recau;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public long getNo_recau() {
        return no_recau;
    }

    public void setNo_recau(long no_recau) {
        this.no_recau = no_recau;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.no_recau ^ (this.no_recau >>> 32));
        hash = 53 * hash + Objects.hashCode(this.domicilio);
        hash = 53 * hash + Objects.hashCode(this.telefono);
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
        final Recaudadora other = (Recaudadora) obj;
        if (this.no_recau != other.no_recau) {
            return false;
        }
        if (!Objects.equals(this.domicilio, other.domicilio)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }


}
