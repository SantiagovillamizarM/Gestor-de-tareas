package com.gestor.infraestructura.persistencia;

import com.gestor.dominio.entidades.EstadoTarea;
import com.gestor.dominio.entidades.Prioridad;
import com.gestor.dominio.entidades.Tarea;
import com.gestor.dominio.repositorios.TareaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TareaRepositoryImpl implements TareaRepository {

    private final Map<String, Tarea> tareas = new HashMap<>();

    @Override
    public void guardar(Tarea tarea) {
        tareas.put(tarea.getId(), tarea);
    }

    @Override
    public Optional<Tarea> buscarPorId(String id) {
        return Optional.ofNullable(tareas.get(id));
    }

    @Override
    public List<Tarea> obtenerTodos() {
        return new ArrayList<>(tareas.values());
    }

    @Override
    public List<Tarea> obtenerPorEstado(EstadoTarea estado) {
        return tareas.values().stream()
                .filter(t -> t.getEstadoTarea() == estado)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tarea> obtenerPorPrioridad(Prioridad prioridad) {
        return tareas.values().stream()
                .filter(t -> t.getPrioridad() == prioridad)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tarea> obtenerPorUsuario(String idUsuario) {
        return tareas.values().stream()
                .filter(t -> t.getUsuario() != null && t.getUsuario().getId().equals(idUsuario))
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(String id) {
        tareas.remove(id);
    }
}