package com.gestor.aplicacion.servicios;
import com.gestor.dominio.entidades.Usuario;
import com.gestor.dominio.excepciones.UsuarioNoEncontradoException;
import com.gestor.dominio.repositorios.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public void registrarUsuario(String id, String nombre, String correo, String rol){
        if (id == null || id.trim().isEmpty() || 
            nombre == null || nombre.trim().isEmpty() ||
            correo == null || correo.trim().isEmpty()){
            throw new IllegalArgumentException("Todos los campos son obligatorios.");  
        }
        if (usuarioRepository.buscarPorId(id).isPresent()){
            throw new IllegalArgumentException("Ya existe un usuario con el ID: "+ id); 
        }
        Usuario nuevoUsuario = new Usuario(id,nombre,correo,rol);
        usuarioRepository.guardar(nuevoUsuario);
    }
    public Usuario buscarPorId(String id){
        return usuarioRepository.buscarPorId(id)
        .orElseThrow(() -> new UsuarioNoEncontradoException("No se encontro el usuario con ID:" + id));
    }
    
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.obtenerTodos();
    }
    
}
