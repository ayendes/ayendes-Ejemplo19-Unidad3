/*
 * Clase Evaluacion
 * 
 */
package com.ejercicio19.evaluacion.modelo;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Abraham Yendes
 */

public class Evaluacion {

    private String id_eva;
    private String nEvaluacion;
    private String puntaje;
    private String peso;
    private String fecha_evaluacion;
    private Usuario usuario;

    public String getId_eva() {
        return id_eva;
    }

    public void setId_eva(String id_eva) {
        this.id_eva = id_eva;
    }

    public String getnEvaluacion() {
        return nEvaluacion;
    }

    public void setnEvaluacion(String nEvaluacion) {
        this.nEvaluacion = nEvaluacion;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getFecha_evaluacion() {
        return fecha_evaluacion;
    }

    public void setFecha_evaluacion(String fecha_evaluacion) {
        this.fecha_evaluacion = fecha_evaluacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
