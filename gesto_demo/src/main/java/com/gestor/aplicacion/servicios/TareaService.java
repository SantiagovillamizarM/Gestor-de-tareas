package com.gestor.aplicacion.servicios;
import com.gestor.dominio.entidades.EstadoTarea;
import com.gestor.dominio.entidades.Prioridad;
import com.gestor.dominio.entidades.Tarea;
import com.gestor.dominio.entidades.Usuario;
import com.gestor.dominio.excepciones.TareaNoEncontradaException;
import com.gestor.dominio.excepciones.UsuarioNoEncontradoException;
//Conjuntos de datos private
import com.gestor.dominio.repositorios.TareaRepository;
import com.gestor.dominio.repositorios.UsuarioRepository;



import java.util.List;

public class TareaService {
    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

    public TareaService(TareaRepository tareaRepository,UsuarioRepository usuarioRepository){
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void crearTarea(String id, String titulo, String descripcion, Prioridad prioridad){
        if (id == null || id.trim().isEmpty() ||
            titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("El ID y el título de la tarea son obligatorios.");
            }

        if (tareaRepository.buscarPorId(id).isPresent()){
            throw new IllegalArgumentException("Ya existe una tarea con el ID: " + id);
        }
        Tarea nuevaTarea = new Tarea(id, titulo, descripcion, prioridad);
        tareaRepository.guardar(nuevaTarea);
    }
    public void asignarUsuarioATarea(String idTarea, String idUsuario) {
        Tarea tarea = buscarPorId(idTarea);

        Usuario usuario = usuarioRepository.buscarPorId(idUsuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException("No se encontró el usuario con ID: " + idUsuario));

        tarea.setUsuarioAsignado(usuario);
        tareaRepository.guardar(tarea); // Actualiza la tarea en el repositorio
    }

    // 3. CAMBIAR ESTADO DE LA TAREA
    public void cambiarEstadoTarea(String idTarea, EstadoTarea nuevoEstado) {
        Tarea tarea = buscarPorId(idTarea);
        tarea.setEstado(nuevoEstado);
        tareaRepository.guardar(tarea);
    }

    // 4. BÚSQUEDAS Y FILTROS
    public Tarea buscarPorId(String idTarea) {
        return tareaRepository.buscarPorId(idTarea)
                .orElseThrow(() -> new TareaNoEncontradaException("No se encontró la tarea con ID: " + idTarea));
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.obtenerTodos();
    }

    public List<Tarea> buscarPorEstado(EstadoTarea estado) {
        return tareaRepository.obtenerPorEstado(estado);
    }

    public List<Tarea> buscarPorPrioridad(Prioridad prioridad) {
        return tareaRepository.obtenerPorPrioridad(prioridad);
    }

    // 5. ELIMINAR TAREA
    public void eliminarTarea(String idTarea) {
        // Verifica primero que exista
        buscarPorId(idTarea);
        tareaRepository.eliminar(idTarea);
    }

}
