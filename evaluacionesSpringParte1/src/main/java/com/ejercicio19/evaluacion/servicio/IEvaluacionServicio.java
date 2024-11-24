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
    
    public List<Evaluacion> listarEvaluaciones();
    
    public void guardar (Evaluacion evaluacion);
    
    public void eliminar (Evaluacion evaluacion);
    
    public Evaluacion buscar (int id);
}
