/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author erni
 */
public class Auto {
    private long  idcar;
    private String modelo;
    private String placas;
    private String color;
    private  long idprop;

    public Auto( String modelo, String placas, String color, long idprop) {
        this.modelo = modelo;
        this.placas = placas;
        this.color = color;
        this.idprop = idprop;
    }

    public long getIdcar() {
        return idcar;
    }

    public void setIdcar(long idcar) {
        this.idcar = idcar;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getIdprop() {
        return idprop;
    }

    public void setIdprop(long idprop) {
        this.idprop = idprop;
    }

    @Override
    public String toString() {
        return "Auto{" + "idcar=" + idcar + ", modelo=" + modelo + ", placas=" + placas + ", color=" + color + ", idprop=" + idprop + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.idcar ^ (this.idcar >>> 32));
        hash = 79 * hash + Objects.hashCode(this.modelo);
        hash = 79 * hash + Objects.hashCode(this.placas);
        hash = 79 * hash + Objects.hashCode(this.color);
        hash = 79 * hash + (int) (this.idprop ^ (this.idprop >>> 32));
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
        final Auto other = (Auto) obj;
        if (this.idcar != other.idcar) {
            return false;
        }
        if (this.idprop != other.idprop) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.placas, other.placas)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

  
    

    
}
