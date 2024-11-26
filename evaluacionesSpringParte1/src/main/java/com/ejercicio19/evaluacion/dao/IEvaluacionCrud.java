/*
 *Interface de Evaluacion 
 * 
 */
package com.ejercicio19.evaluacion.dao;

import com.ejercicio19.evaluacion.modelo.Evaluacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 *
 * @author DAbraham Yendes
 */

@Repository
public interface IEvaluacionCrud extends CrudRepository<Evaluacion, Integer> {
 
    
    List<Evaluacion> findByNombre(String nombre);

    public Evaluacion findById(int evaId);

}
    
