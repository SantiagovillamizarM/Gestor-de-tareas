package com.gestor.dominio.entidades;

import java.io.Serializable;

public class Tarea implements Serializable {

    private final String id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private EstadoTarea estado;
    private Usuario usuarioAsignado;

    public Tarea(String id, String titulo, String descripcion, Prioridad prioridad){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = EstadoTarea.POR_REALIZAR;
        this.usuarioAsignado = null;
    } 

    public String getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Prioridad getPrioridad(){
        return prioridad;
    }
    public EstadoTarea getEstadoTarea(){
        return estado;
    }
    public Usuario getUsuario(){
        return usuarioAsignado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }
    @Override
    public String toString() {
        String responsable = (usuarioAsignado != null) ? usuarioAsignado.getNombre() : "Sin asignar";
        return "[" + estado + "] " + titulo + " (Prioridad: " + prioridad + " | Resp: " + responsable + ")";
    }
}