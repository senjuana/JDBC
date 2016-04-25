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
public class Propietario {
    private String nombre;
    private String apellido;
    private String apellido2;
    private long edad;
    private  long idprop;

    public Propietario(String nombre, String apellido, String apellido2, long edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.edad = edad;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public long getIdprop() {
        return idprop;
    }

    public void setIdprop(long idprop) {
        this.idprop = idprop;
    }

    @Override
    public String toString() {
        return "Propietario{" + "nombre=" + nombre + ", apellido=" + apellido + ", apellido2=" + apellido2 + ", edad=" + edad + ", idprop=" + idprop + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.apellido);
        hash = 67 * hash + Objects.hashCode(this.apellido2);
        hash = 67 * hash + (int) (this.edad ^ (this.edad >>> 32));
        hash = 67 * hash + (int) (this.idprop ^ (this.idprop >>> 32));
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
        final Propietario other = (Propietario) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (this.idprop != other.idprop) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        return true;
    }

  
    
}
