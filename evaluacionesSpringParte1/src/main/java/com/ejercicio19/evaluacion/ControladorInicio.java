/*
 * Controlador Inicial
 * 
 */
package com.ejercicio19.evaluacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

/**
 *
 * @author Abraham Yendes
 */
@Controller

public class ControladorInicio {

    @Value("${index.mensaje}")
    String dato;
    private static final Logger logger = LogManager.getLogger(ControladorInicio.class);

    @GetMapping("/")
    public String inicio(Model model) {

        String mensaje = "Spring MVC";
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
        logger.info("Ejecutando el controlador inicio");
        return "index";
    }
}
