/*
 * Interface Servicios Evaluacion
 * 
 */
package com.ejercicio19.evaluacion.servicio;

import java.util.List;
import com.ejercicio19.evaluacion.modelo.Evaluacion;

/**
 *
 * @author Abraham Yendes
 */
public interface IEvaluacionServicio {
    
    public void guardar (Evaluacion evaluacion);
    
    public Evaluacion buscar (int evaId);
    
    public void eliminar (Evaluacion evaluacion);
    
    public List<Evaluacion> listarEvaluaciones();
}
