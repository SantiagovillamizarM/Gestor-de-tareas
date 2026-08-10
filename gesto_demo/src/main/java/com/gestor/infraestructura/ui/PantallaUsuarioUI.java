package com.gestor.infraestructura.ui;

import com.gestor.aplicacion.servicios.UsuarioService;
import com.gestor.dominio.entidades.Usuario;

import javax.swing.JOptionPane;
import java.util.List;

public class PantallaUsuarioUI {

    private final UsuarioService usuarioService;

    public PantallaUsuarioUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void mostrarMenu() {
        String[] opciones = {
            "Registrar Usuario",
            "Listar Todos los Usuarios",
            "Buscar Usuario por ID",
            "Volver al Menú Principal"
        };

        boolean volver = false;

        while (!volver) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "--- GESTIÓN DE USUARIOS ---",
                "Menú Usuarios",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (seleccion) {
                case 0:
                    registrarUsuario();
                    break;
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    buscarUsuarioPorId();
                    break;
                case 3:
                case JOptionPane.CLOSED_OPTION:
                    volver = true;
                    break;
            }
        }
    }

    private void registrarUsuario() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario:");
        if (id == null) return; // Si presiona cancelar

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:");
        if (nombre == null) return;

        String correo = JOptionPane.showInputDialog(null, "Ingrese el correo:");
        if (correo == null) return;

        String rol = JOptionPane.showInputDialog(null, "Ingrese el rol (Ej: Admin, Dev, Tester):");
        if (rol == null) return;

        try {
            usuarioService.registrarUsuario(id, nombre, correo, rol);
            JOptionPane.showMessageDialog(null, "¡Usuario registrado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodos();

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados actualmente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("--- LISTA DE USUARIOS ---\n\n");
        for (Usuario u : usuarios) {
            sb.append("ID: ").append(u.getId())
              .append(" | Nombre: ").append(u.getNombre())
              .append(" | Correo: ").append(u.getCorreo())
              .append(" | Rol: ").append(u.getRol())
              .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Usuarios Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarUsuarioPorId() {
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario a buscar:");
        if (id == null) return;

        try {
            Usuario u = usuarioService.buscarPorId(id);
            String info = "ID: " + u.getId() + "\n" +
                          "Nombre: " + u.getNombre() + "\n" +
                          "Correo: " + u.getCorreo() + "\n" +
                          "Rol: " + u.getRol();
            JOptionPane.showMessageDialog(null, info, "Detalle de Usuario", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}