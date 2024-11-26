/*
 *Interface de CRUD de Usuario
 * 
 */
package com.ejercicio19.evaluacion.dao;

import com.ejercicio19.evaluacion.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author Abraham Yendes
 */

@Repository
public interface IUsuarioCrud extends CrudRepository<Usuario, Integer> {
    
        List<Usuario> findByNombre(String nombre);

        public Usuario findById(int userId);
    
}
