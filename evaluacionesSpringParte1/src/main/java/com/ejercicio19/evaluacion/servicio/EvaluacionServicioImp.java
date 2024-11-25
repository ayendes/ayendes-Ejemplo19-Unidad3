/*
 * 
 * 
 */
package com.ejercicio19.evaluacion.servicio;

import java.util.List;
import com.ejercicio19.evaluacion.dao.IEvaluacionCrud;
import com.ejercicio19.evaluacion.modelo.Evaluacion;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.ejercicio19.evaluacion.modelo.Usuario;

/**
 *
 * @author Abraham Yendes
 */
@EnableTransactionManagement
@Service
public class EvaluacionServicioImp implements IEvaluacionServicio {

    @Autowired
    IEvaluacionCrud evaluacionCrud;

    @Transactional //(readOnly = true)
    @Override
    public List<Evaluacion> listarEvaluaciones() {

        return (List<Evaluacion>) evaluacionCrud.findAll();
    }

    @Transactional
    @Override
    public void guardar(Evaluacion evaluacion) {

        evaluacionCrud.save(evaluacion);
    }

    @Transactional
    @Override
    public void eliminar(Evaluacion evaluacion) {

        evaluacionCrud.delete(evaluacion);
    }
    
    @Transactional //(readOnly = true)

    @Override
    public Evaluacion buscar(int id) {
        return evaluacionCrud.findById(id).orElse(null);
    }

    @Override
    public void asignarNombreUsuario(int evaluacionId, Usuario usuario) {
        Evaluacion evaluacion = evaluacionCrud.findById(evaluacionId).orElse(null);
        if (evaluacion != null && usuario != null) {
            evaluacion.asignarNombreUsuario(usuario);
            evaluacionCrud.save(evaluacion); // Guarda la evaluación actualizada
        }
    }
    
}
