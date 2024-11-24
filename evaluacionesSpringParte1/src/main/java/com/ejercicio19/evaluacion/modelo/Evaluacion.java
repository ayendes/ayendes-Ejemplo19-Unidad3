/*
 * Clase Evaluacion
 * 
 */
package com.ejercicio19.evaluacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import java.io.Serializable;


/**
 *
 * @author Abraham Yendes
 */
@Entity
@Table(name = "evaluaciones")
@Data
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String nombre;
    private int puntaje;
    private float peso;
    private Date fecha_evaluacion;
    private int usuario_id;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Date getFecha_evaluacion() {
        return fecha_evaluacion;
    }

    public void setFecha_evaluacion(Date fecha_evaluacion) {
        this.fecha_evaluacion = fecha_evaluacion;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    
}
