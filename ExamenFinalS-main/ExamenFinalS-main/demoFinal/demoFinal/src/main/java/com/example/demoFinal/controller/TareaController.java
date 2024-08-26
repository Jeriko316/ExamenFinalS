package com.example.demoFinal.controller;

import com.example.demoFinal.model.Tarea1;
import com.example.demoFinal.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {


    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea1> crearTarea(@RequestBody Tarea1 tarea) {
        Tarea1 nuevaTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea1> actualizarTarea(@PathVariable Integer id, @RequestBody Tarea1 tarea) {
        Tarea1 tareaActualizada = tareaService.actualizarTarea(id, tarea);
        return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tarea1>> buscarTodo() {
        List<Tarea1> tareas = tareaService.buscarTodo();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Tarea1>> buscarPorEstado(@PathVariable boolean estado) {
        List<Tarea1> tareas = tareaService.buscarPorEstado(estado);
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Integer id) {
        tareaService.eliminarTarea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
