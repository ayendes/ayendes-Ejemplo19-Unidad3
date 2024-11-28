/*
 * Clase Usuario
 * 
 */
package com.ejercicio19.evaluacion.modelo;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "usuarios", catalog = "ejercicio19")
@Data
public class Usuario implements Serializable{

    private static final Long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Si el ID es autogenerado
    @Column(name = "userId", nullable = false, length = 15)
    private long userId;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String rol;
    @Email
    private String email;
    @NotEmpty
    private String telefono;
    @NotEmpty
    private String estado;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_registro;

    public Usuario() {
    }
    

     // Métodos getter y setter

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public Usuario orElse(Usuario usuario) {
        if (this == null) {
            // Si la instancia actual es null, devuelve una nueva Evaluacion
            // Asegúrate de que el objeto sea del tipo adecuado
            if (usuario instanceof Usuario) {
                return (Usuario) usuario; // Devuelve el objeto pasado como parámetro
            } else {
                // Manejo si el objeto no es de tipo Evaluacion
                throw new IllegalArgumentException("El objeto proporcionado no es una instancia de Usuario.");
            }
        }
        return this; // Si no es null, devuelve la instancia actual
    }
}
