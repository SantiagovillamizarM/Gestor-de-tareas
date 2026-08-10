//Indica la ubicacion del archivo dentro del proyecto
package com.gestor.dominio.repositorios;
//Import de la informacion de Tarea
import com.gestor.dominio.entidades.Tarea;
//Import de la informacion de Prioridad
import com.gestor.dominio.entidades.Prioridad;
//Import de la informacion de EstadoTarea
import com.gestor.dominio.entidades.EstadoTarea;

import java.util.List;
import java.util.Optional;

//Lo que dice con interface es que esto son un grupo de reglas OBLIGATORIAS
public interface TareaRepository {
    void guardar(Tarea tarea);
    Optional<Tarea> buscarPorId(String id); // Dice que va haber un metodo para buscar por el id
    List<Tarea> obtenerTodos(); // para obtener todos los datos
    List<Tarea> obtenerPorEstado(EstadoTarea estado); // obtener las cosas por el estado
    List<Tarea> obtenerPorPrioridad(Prioridad prioridad); // Obtener las cosas por prioridad
    List<Tarea> obtenerPorUsuario(String idUsuario);// Obtener por el id del usuario
    void eliminar(String id);
}
