package com.gestor.infraestructura.ui;

import com.gestor.aplicacion.servicios.TareaService;
import com.gestor.aplicacion.servicios.UsuarioService;

import javax.swing.JOptionPane;

public class MenuPrincipalUI {

    private final PantallaUsuarioUI pantallaUsuarioUI;
    private final PantallaTareaUI pantallaTareaUI;

    public MenuPrincipalUI(UsuarioService usuarioService, TareaService tareaService) {
        this.pantallaUsuarioUI = new PantallaUsuarioUI(usuarioService);
        this.pantallaTareaUI = new PantallaTareaUI(tareaService);
    }

    public void mostrarMenu() {
        String[] opciones = {
            "Gestión de Usuarios",
            "Gestión de Tareas",
            "Salir"
        };

        boolean salir = false;

        while (!salir) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "--- GESTOR DE TAREAS Y USUARIOS ---\n\nSeleccione una opción para continuar:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (seleccion) {
                case 0:
                    pantallaUsuarioUI.mostrarMenu();
                    break;
                case 1:
                    pantallaTareaUI.mostrarMenu();
                    break;
                case 2:
                case JOptionPane.CLOSED_OPTION:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "¡Hasta luego! Aplicación finalizada.");
                    break;
            }
        }
    }
}