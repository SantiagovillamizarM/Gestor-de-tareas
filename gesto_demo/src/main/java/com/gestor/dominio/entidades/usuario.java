//Indica la ubicacion del archivo dentro del proyecto 
package com.gestor.dominio.entidades;

//Se usa para la persistencia de datos
import java.io.Serializable;

//Dice que implementa el serializable 
public class Usuario implements Serializable {
    //Condicion del javabean (Tener los datos en privado para la seguridad de ellos mismos)
    private final String id; //Datos inmutables
    private String nombre;
    private String correo;
    private final String rol; //Datos inmutables

    //Constructor
    // es para para asignar e inicializar los valores reales cuando creas un usuario por primera vez.
    // En este caso los valores del id, nombre,correo y rol
    public Usuario(String id, String nombre, String correo, String rol){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }   

    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getId(){
        return id;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getNombre(){
        return nombre;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getCorreo(){
        return correo;
    }
    //Getter
    //Para traer los datos sin afectar a los datos originales (Solo para leer)
    public String getRol(){
        return rol;
    }

    //SETTER
    //Sobreescriben el valor
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //SETTER
    //Sobreescriben el valor
    public void setCorreo(String correo){
        this.correo = correo;
    }

    //Plantilla de lo que debe imprimir
    //En este caso imprime el rol y el id
    //Overrride es para sobre escribir los datos de una mejor manera
    @Override
    public String toString() {
        return nombre + " (" + rol + ") - ID: " + id;
    }
}

