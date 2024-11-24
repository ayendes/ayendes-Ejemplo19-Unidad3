/*
 *Interface de Evaluacion 
 * 
 */
package com.ejercicio19.evaluacion.dao;

import org.springframework.beans.factory.annotation.Autowired;
import com.ejercicio19.evaluacion.modelo.Evaluacion;
import jakarta.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Dina Perez
 */

@Repository
public interface IEvaluacionCrud extends CrudRepository<Evaluacion, Integer> {
 
    
    List<Evaluacion> findByNombre(String nombre);

    public Evaluacion findById(int id);

}
    
