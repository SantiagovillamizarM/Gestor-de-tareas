package com.gestor.dominio.entidades;
import java.io.Serializable;

public class Usuario implements Serializable {
    private final String id;
    private String nombre;
    private String correo;
    private final String rol;

    public Usuario(String id, String nombre, String correo, String rol){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }   

    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getRol(){
        return rol;
    }

    // SETTERS

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombre + " (" + rol + ") - ID: " + id;
    }
}

