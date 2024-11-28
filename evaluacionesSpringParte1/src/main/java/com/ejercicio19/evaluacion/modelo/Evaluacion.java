/*
 * Clase Evaluacion
 * 
 */
package com.ejercicio19.evaluacion.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Abraham Yendes
 */
@Entity
@Table(name = "evaluaciones", catalog = "ejercicio19")
@Data
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Si el ID es autogenerado
    @Column(name = "evaId", nullable = false, length = 15)
    private long evaId;
    @NotEmpty
    private String nombre;
    @NotNull
    private int puntaje;
    @NotNull
    private float peso;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_evaluacion;
    private int usuario_id;

    public Evaluacion() {
    }

    // Métodos getter y setter
    public long getEvaId() {
        return evaId;
    }

    public void setEvaId(long evaId) {
        this.evaId = evaId;
    }

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

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Evaluacion orElse(Evaluacion evaluacion) {
        if (this == null) {
            // Si la instancia actual es null, devuelve una nueva Evaluacion
            // Asegúrate de que el objeto sea del tipo adecuado
            if (evaluacion instanceof Evaluacion) {
                return (Evaluacion) evaluacion; // Devuelve el objeto pasado como parámetro
            } else {
                // Manejo si el objeto no es de tipo Evaluacion
                throw new IllegalArgumentException("El objeto proporcionado no es una instancia de Evaluacion.");
            }
        }
        return this; // Si no es null, devuelve la instancia actual
    }
}
