//Indica la ubicacion del archivo dentro del proyecto
package com.gestor.dominio.entidades;

//Se usa para la persistencia de datos
import java.io.Serializable;

//Dice que implementa el serializable 
public class Tarea implements Serializable {
    //Condicion del javabean (Tener los datos en privado para la seguridad de ellos mismos)
    private final String id;// Dato inmutable
    private String titulo;
    private String descripcion;
    private Prioridad prioridad; //Enum personalizada
    private EstadoTarea estado; //Enum personalizada
    private Usuario usuarioAsignado; // Entidad personalizada

    //Constructor
    // es para para asignar e inicializar los valores reales cuando creas un usuario por primera vez.
    // En este caso los valores del id, nombre,correo y rol
    public Tarea(String id, String titulo, String descripcion, Prioridad prioridad){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = EstadoTarea.POR_REALIZAR;
        this.usuarioAsignado = null;
    } 
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getId(){
        return id;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getTitulo(){
        return titulo;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getDescripcion(){
        return descripcion;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public Prioridad getPrioridad(){
        return prioridad;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public EstadoTarea getEstadoTarea(){
        return estado;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public Usuario getUsuario(){
        return usuarioAsignado;
    }
    //SETTER
    //Sobreescriben el valor
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //SETTER
    //Sobreescriben el valor
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //SETTER
    //Sobreescriben el valor
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    //SETTER
    //Sobreescriben el valor
    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }
    //SETTER
    //Sobreescriben el valor
    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }
    //La plantilla con la sobreescritura para que los datos se vean bien
    @Override
    public String toString() {
        String responsable = (usuarioAsignado != null) ? usuarioAsignado.getNombre() : "Sin asignar";
        return "[" + estado + "] " + titulo + " (Prioridad: " + prioridad + " | Resp: " + responsable + ")";
    }
}