package com.example.demoFinal.service;

import com.example.demoFinal.model.Tarea1;
import com.example.demoFinal.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TareaService  {

    @Autowired
    private TareaRepository tareaRepository;


    public Tarea1 crearTarea(Tarea1 tarea){
        tarea.setFechaCreacion(LocalDateTime.now());
        return this.tareaRepository.save(tarea);
    }


    public Tarea1 actualizarTarea(Integer id, Tarea1 tarea){
        return tareaRepository.findById(id)
                .map(existingTarea -> {
                    existingTarea.setTitulo(tarea.getTitulo());
                    existingTarea.setDescripcion(tarea.getDescripcion());
                    existingTarea.setUsuario(tarea.getUsuario()); // Update the user if necessary
                    return tareaRepository.save(existingTarea);
                })
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public List<Tarea1> buscarTodo(){
          return this.tareaRepository.findAll();
    }

    public void eliminarTarea(Integer id){
         this.tareaRepository.deleteById(id);
    }





}
