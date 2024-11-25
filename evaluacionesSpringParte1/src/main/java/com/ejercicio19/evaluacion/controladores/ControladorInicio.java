/*
 * Controlador Inicial
 * 
 */
package com.ejercicio19.evaluacion.controladores;

import lombok.extern.slf4j.Slf4j;
import com.ejercicio19.evaluacion.servicio.IEvaluacionServicio;
import com.ejercicio19.evaluacion.dao.IEvaluacionCrud;
import org.springframework.beans.factory.annotation.Autowire;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;
import com.ejercicio19.evaluacion.modelo.Evaluacion;
import com.ejercicio19.evaluacion.modelo.Usuario;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Abraham Yendes
 */
@EnableTransactionManagement
@Controller
@Slf4j

public class ControladorInicio {

    //@Value("${index.mensaje}")
    //String dato;
    private static final Logger logger = LogManager.getLogger(ControladorInicio.class);
    @Autowired
    //IEvaluacionCrud evaluacionCrud;
    IEvaluacionServicio evaluacionServicio;
    
    @GetMapping("/")
    public String inicio(Model model) {

        /*String mensaje = "Spring MVC";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("dato", dato);
        Evaluacion e1 = new Evaluacion();
        e1.setnEvaluacion("Matemáticas");
        e1.setPuntaje("4");
        e1.setPeso("3");
        e1.setFecha_evaluacion("2024-10-23");
        model.addAttribute("nota", e1);
        
        Evaluacion e2 = new Evaluacion();
        e2.setnEvaluacion("Lenguaje");
        e2.setPuntaje("3.3");
        e2.setPeso("3");
        e2.setFecha_evaluacion("2024-10-24");
        
        Evaluacion e3 = new Evaluacion();
        e3.setnEvaluacion("Fisica");
        e3.setPuntaje("4.1");
        e3.setPeso("3");
        e3.setFecha_evaluacion("2024-10-22");
        
        List<Evaluacion> listaEvaluaciones = Arrays.asList(e2, e3);
        model.addAttribute("evaluaciones", listaEvaluaciones);
*/  
        //List<Evaluacion> listaEvaluaciones = (List<Evaluacion>) evaluacionCrud.findAll();
        List<Evaluacion> listaEvaluaciones = (List<Evaluacion>) evaluacionServicio.listarEvaluaciones();
        model.addAttribute("evaluaciones", listaEvaluaciones);
        logger.info("Ejecutando el controlador inicio");
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Evaluacion evaluacion) {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Evaluacion evaluacion) {    
        evaluacionServicio.guardar(evaluacion);
        return "redirect:/evaluaciones/";
    }

    @RequestMapping("/evaluaciones") // Cambia la ruta base
    @PostMapping("/{evaluacionId}/asignar-usuario")
    public ResponseEntity<String> asignarUsuario(@PathVariable int evaluacionId, @ModelAttribute Usuario usuario) {
        evaluacionServicio.asignarNombreUsuario(evaluacionId, usuario);
        return ResponseEntity.ok("Nombre de usuario asignado correctamente");
    }
}
