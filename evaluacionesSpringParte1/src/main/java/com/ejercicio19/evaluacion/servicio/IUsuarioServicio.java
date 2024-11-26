/*
 * Interface Servicios de Usuario
 * 
 */
package com.ejercicio19.evaluacion.servicio;

import java.util.List;
import com.ejercicio19.evaluacion.modelo.Usuario;

/**
 *
 * @author Abraham Yendes
 */

public interface IUsuarioServicio {
    
    public void guardar (Usuario usuario);
    
    public Usuario buscar (int userId);
    
    public void eliminar (Usuario usuario);
    
    public List<Usuario> listarUsuarios();
    
}
