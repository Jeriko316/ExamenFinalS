package com.example.demoFinal.controller;

import com.example.demoFinal.model.Tarea1;
import com.example.demoFinal.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/tarea")
public class TareaController {


    @Autowired
    private TareaService tareaService;


    @PostMapping("/insertar")
    public String insertar(Tarea1 tarea) {
        this.tareaService.crearTarea(tarea);
        return "redirect:/tarea/buscarTodos";
    }


    @GetMapping("/buscarTodos")
    public String buscarTodos(Model modelo) {
        List<Tarea1> lista=this.tareaService.buscarTodo();
        modelo.addAttribute("tareas",lista);
        return "vistaListaTarea";
    }


    @GetMapping("/mostrar")
    public String mostrarTarea(Model modelo) {
        modelo.addAttribute("tareas", new Tarea1());
        return "vistaNuevaTarea";
    }


}
