package com.gestor.infraestructura.ui;

import com.gestor.aplicacion.servicios.TareaService;
import com.gestor.dominio.entidades.EstadoTarea;
import com.gestor.dominio.entidades.Prioridad;
import com.gestor.dominio.entidades.Tarea;

import javax.swing.JOptionPane;
import java.util.List;

public class PantallaTareaUI {

    private final TareaService tareaService;

    public PantallaTareaUI(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    public void mostrarMenu() {
        String[] opciones = {
            "Crear Tarea",
            "Asignar Tarea a Usuario",
            "Cambiar Estado de Tarea",
            "Listar Todas las Tareas",
            "Filtrar por Estado",
            "Filtrar por Prioridad",
            "Eliminar Tarea",
            "Volver al Menú Principal"
        };

        boolean volver = false;

        while (!volver) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "--- GESTIÓN DE TAREAS ---",
                "Menú Tareas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (seleccion) {
                case 0:
                    crearTarea();
                    break;
                case 1:
                    asignarTarea();
                    break;
                case 2:
                    cambiarEstadoTarea();
                    break;
                case 3:
                    listarTareas(tareaService.obtenerTodasLasTareas(), "Todas las Tareas");
                    break;
                case 4:
                    filtrarPorEstado();
                    break;
                case 5:
                    filtrarPorPrioridad();
                    break;
                case 6:
                    eliminarTarea();
                    break;
                case 7:
                case JOptionPane.CLOSED_OPTION:
                    volver = true;
                    break;
            }
        }
    }

    private void crearTarea() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID de la tarea:");
        if (id == null) return;

        String titulo = JOptionPane.showInputDialog(null, "Ingrese el título:");
        if (titulo == null) return;

        String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción:");
        if (descripcion == null) return;

        // Selección de Prioridad desde el Enum
        Prioridad prioridad = (Prioridad) JOptionPane.showInputDialog(
            null,
            "Seleccione la prioridad:",
            "Prioridad",
            JOptionPane.QUESTION_MESSAGE,
            null,
            Prioridad.values(),
            Prioridad.MEDIA
        );

        if (prioridad == null) return;

        try {
            tareaService.crearTarea(id, titulo, descripcion, prioridad);
            JOptionPane.showMessageDialog(null, "¡Tarea creada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarTarea() {
        String idTarea = JOptionPane.showInputDialog(null, "Ingrese el ID de la tarea:");
        if (idTarea == null) return;

        String idUsuario = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario a asignar:");
        if (idUsuario == null) return;

        try {
            tareaService.asignarUsuarioATarea(idTarea, idUsuario);
            JOptionPane.showMessageDialog(null, "¡Tarea asignada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cambiarEstadoTarea() {
        String idTarea = JOptionPane.showInputDialog(null, "Ingrese el ID de la tarea:");
        if (idTarea == null) return;

        EstadoTarea nuevoEstado = (EstadoTarea) JOptionPane.showInputDialog(
            null,
            "Seleccione el nuevo estado:",
            "Estado Tarea",
            JOptionPane.QUESTION_MESSAGE,
            null,
            EstadoTarea.values(),
            EstadoTarea.EN_PROCESO
        );

        if (nuevoEstado == null) return;

        try {
            tareaService.cambiarEstadoTarea(idTarea, nuevoEstado);
            JOptionPane.showMessageDialog(null, "¡Estado actualizado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filtrarPorEstado() {
        EstadoTarea estado = (EstadoTarea) JOptionPane.showInputDialog(
            null,
            "Seleccione el estado a filtrar:",
            "Filtro Estado",
            JOptionPane.QUESTION_MESSAGE,
            null,
            EstadoTarea.values(),
            EstadoTarea.POR_REALIZAR
        );

        if (estado != null) {
            listarTareas(tareaService.buscarPorEstado(estado), "Tareas con estado: " + estado);
        }
    }

    private void filtrarPorPrioridad() {
        Prioridad prioridad = (Prioridad) JOptionPane.showInputDialog(
            null,
            "Seleccione la prioridad a filtrar:",
            "Filtro Prioridad",
            JOptionPane.QUESTION_MESSAGE,
            null,
            Prioridad.values(),
            Prioridad.ALTA
        );

        if (prioridad != null) {
            listarTareas(tareaService.buscarPorPrioridad(prioridad), "Tareas con prioridad: " + prioridad);
        }
    }

    private void eliminarTarea() {
        String idTarea = JOptionPane.showInputDialog(null, "Ingrese el ID de la tarea a eliminar:");
        if (idTarea == null) return;

        try {
            tareaService.eliminarTarea(idTarea);
            JOptionPane.showMessageDialog(null, "¡Tarea eliminada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarTareas(List<Tarea> tareas, String tituloVentana) {
        if (tareas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron tareas.", tituloVentana, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("--- " + tituloVentana.toUpperCase() + " ---\n\n");
        for (Tarea t : tareas) {
            sb.append(t.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), tituloVentana, JOptionPane.INFORMATION_MESSAGE);
    }
}