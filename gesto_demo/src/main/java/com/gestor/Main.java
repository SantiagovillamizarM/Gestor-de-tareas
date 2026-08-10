package com.gestor;

import com.gestor.aplicacion.servicios.TareaService;
import com.gestor.aplicacion.servicios.UsuarioService;
import com.gestor.dominio.repositorios.TareaRepository;
import com.gestor.dominio.repositorios.UsuarioRepository;
import com.gestor.infraestructura.persistencia.TareaRepositoryImpl;
import com.gestor.infraestructura.persistencia.UsuarioRepositoryImpl;
import com.gestor.infraestructura.ui.MenuPrincipalUI;

public class Main {

    public static void main(String[] args) {
        // 1. Instanciar Capa de Persistencia (Infraestructura)
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
        TareaRepository tareaRepository = new TareaRepositoryImpl();

        // 2. Instanciar Capa de Servicios (Aplicación) inyectando los repositorios
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        TareaService tareaService = new TareaService(tareaRepository, usuarioRepository);

        // 3. Instanciar Capa de Interfaz (UI) inyectando los servicios
        MenuPrincipalUI menuPrincipalUI = new MenuPrincipalUI(usuarioService, tareaService);

        // 4. Iniciar la aplicación
        menuPrincipalUI.mostrarMenu();
    }
}