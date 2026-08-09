package com.gestor.dominio.repositorios;
import com.gestor.dominio.entidades.Tarea;
import com.gestor.dominio.entidades.Prioridad;
import com.gestor.dominio.entidades.EstadoTarea;
import java.util.List;
import java.util.Optional;

public interface TareaRepository {
    void guardar(Tarea tarea);
    Optional<Tarea> buscarPorId(String id);
    List<Tarea> obtenerTodos();
    List<Tarea> obtenerPorEstado(EstadoTarea estado);
    List<Tarea> obtenerPorPrioridad(Prioridad prioridad);
    List<Tarea> obtenerPorUsuario(String idUsuario);
    void eliminar(String id);
}
