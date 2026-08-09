package com.gestor.dominio.repositorios;
import com.gestor.dominio.entidades.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    void guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(String id);
    List<Usuario> obtenerTodos();
    
}
