/*
 * Controlador Inicial
 * 
 */
package com.ejercicio19.evaluacion.controladores;

import lombok.extern.slf4j.Slf4j;
import com.ejercicio19.evaluacion.servicio.IEvaluacionServicio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.ejercicio19.evaluacion.modelo.Evaluacion;
import com.ejercicio19.evaluacion.modelo.Usuario;
import com.ejercicio19.evaluacion.servicio.IUsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
import org.springframework.validation.Errors;
/**
 *
 * @author Abraham Yendes
 */
@EnableTransactionManagement
@Controller
@Slf4j

public class ControladorInicio {

    private static final Logger logger = LogManager.getLogger(ControladorInicio.class);
    @Autowired
    IEvaluacionServicio evaluacionServicio;
    @Autowired
    IUsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String inicio(Model model) {

        List<Usuario> listaUsuarios = (List<Usuario>) usuarioServicio.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);

        List<Evaluacion> listaEvaluaciones = (List<Evaluacion>) evaluacionServicio.listarEvaluaciones();
        model.addAttribute("evaluaciones", listaEvaluaciones);

        logger.info("Ejecutando el controlador inicio");
        return "index";
    }
    
    // Mapping Evaluaciones

    @GetMapping("/agregarEvaluacion")
    public String agregar(Evaluacion evaluacion) {
        return "agregarEvaluacion";
    }

    @PostMapping("/guardarEvaluacion")
    public String guardar(@Valid @ModelAttribute ("evaluacion") Evaluacion evaluacion, Errors errores) {
        if(errores.hasErrors()){
            return "modificarEvaluacion";
        }
        evaluacionServicio.guardar(evaluacion);
        return "redirect:/";
    }

    @GetMapping("/editarEvaluacion/{evaId}")
    public String editar(Evaluacion evaluacion, Model model) {
        logger.info("Invocando el metodo EDITAR");
        //Conversion de long a int
        long longEvaId = evaluacion.getEvaId();
        int intEvaId = (int) longEvaId;
        evaluacion = evaluacionServicio.buscar(intEvaId);
        model.addAttribute("evaluacion", evaluacion);
        return "modificarEvaluacion";
    }
    
    @GetMapping("/eliminarEvaluacion")
    public String eliminar(Evaluacion evaluacion) {
        evaluacionServicio.eliminar(evaluacion);
        return "redirect:/";
    }
    
    @GetMapping("/listarEvaluaciones")
    public String listaTodas(Evaluacion evaluacion, Model model) {
        List<Evaluacion> listaEvaluaciones = (List<Evaluacion>) evaluacionServicio.listarEvaluaciones();
        model.addAttribute("evaluaciones", listaEvaluaciones);
        return "listarEvaluaciones";
    }
    
    //Mapping Tabla Usuarios

    @GetMapping("/agregarUsuario")
    public String agregar(Usuario usuario) {
        return "agregarUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardar(@Valid @ModelAttribute("usuario") Usuario usuario, Errors errores) {
        if(errores.hasErrors()){
            return "modificarUsuario";
        }
        usuarioServicio.guardar(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/editarUsuario/{userId}")
    public String editar(Usuario usuario, Model model) {
        logger.info("Invocando el metodo EDITAR");
        long longUserId = usuario.getUserId();
        int intUserId = (int) longUserId;
        usuario = usuarioServicio.buscar(intUserId);
        model.addAttribute("usuario", usuario);
        return "modificarUsuario";
    }
    
    @GetMapping("/eliminarUsuario")
    public String eliminar(Usuario usuario) {
        usuarioServicio.eliminar(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/listarUsuarios")
    public String listaTodas(Usuario usuario, Model model) {
        List<Usuario> listaUsuarios = (List<Usuario>) usuarioServicio.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }
}
