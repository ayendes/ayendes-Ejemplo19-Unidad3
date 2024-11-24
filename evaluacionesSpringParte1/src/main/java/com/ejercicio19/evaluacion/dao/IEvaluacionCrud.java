/*
 *Interface de Evaluacion 
 * 
 */
package com.ejercicio19.evaluacion.dao;

import org.springframework.beans.factory.annotation.Autowired;
import com.ejercicio19.evaluacion.modelo.Evaluacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author Dina Perez
 */

@Repository
public interface IEvaluacionCrud extends CrudRepository<Evaluacion, String> {
 
    
    List<Evaluacion> findByNombre(String nombre);

}
    
