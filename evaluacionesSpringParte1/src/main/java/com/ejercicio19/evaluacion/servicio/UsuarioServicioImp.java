/*
 * Implementacion de Servicio de Usuario
 * 
 */
package com.ejercicio19.evaluacion.servicio;

import java.util.List;
import com.ejercicio19.evaluacion.dao.IUsuarioCrud;
import com.ejercicio19.evaluacion.modelo.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Abraham Yendes
 */

@EnableTransactionManagement
@Service

public class UsuarioServicioImp implements IUsuarioServicio {
    
    @Autowired
    IUsuarioCrud usuarioCrud;

    @Transactional //(readOnly = true)
    @Override
    public List<Usuario> listarUsuarios() {

        return (List<Usuario>) usuarioCrud.findAll();
    }

    @Transactional
    @Override
    public void guardar(Usuario usuario) {

        usuarioCrud.save(usuario);
    }

    @Transactional
    @Override
    public void eliminar(Usuario usuario) {

        usuarioCrud.delete(usuario);
    }
    
    @Transactional //(readOnly = true)

    @Override
    public Usuario buscar(int userId) {
        return usuarioCrud.findById(userId).orElse(null);
    }
    
}
