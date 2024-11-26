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

    @GetMapping("/agregarEvaluacion")
    public String agregar(Evaluacion evaluacion) {
        return "modificarEvaluacion";
    }

    @PostMapping("/guardarEvaluacion")
    public String guardar(@ModelAttribute Evaluacion evaluacion) {
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

    @GetMapping("/agregarUsuario")
    public String agregar(Usuario usuario) {
        return "modificarUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardar(@ModelAttribute Usuario usuario) {
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
}
