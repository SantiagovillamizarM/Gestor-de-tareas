//Indica la ubicacion del archivo dentro del proyecto
package com.gestor.dominio.repositorios;
//Import de la informacion de Usuario
import com.gestor.dominio.entidades.Usuario;

import java.util.List;
import java.util.Optional;

//Lo que dice con interface es que esto son un grupo de reglas OBLIGATORIAS
public interface UsuarioRepository {
    void guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(String id);// Obtener los datos por id
    List<Usuario> obtenerTodos();//obtener todos los datos del usuario
    
}
