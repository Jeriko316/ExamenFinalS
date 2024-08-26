package com.example.demoFinal.service;

import com.example.demoFinal.model.Tarea1;
import com.example.demoFinal.model.Usuario;
import com.example.demoFinal.repository.TareaRepository;
import com.example.demoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TareaService  {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tarea1 crearTarea(Tarea1 tarea) {
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setEstado(false); // Estado por defecto al crear

        // Verifica si el usuario está en la base de datos
        if (tarea.getUsuario() != null && tarea.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(tarea.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            tarea.setUsuario(usuario);
        }

        return tareaRepository.save(tarea);
    }

    public Tarea1 actualizarTarea(Integer id, Tarea1 tarea) {
        return tareaRepository.findById(id)
                .map(existingTarea -> {
                    existingTarea.setTitulo(tarea.getTitulo());
                    existingTarea.setDescripcion(tarea.getDescripcion());
                    existingTarea.setEstado(tarea.isEstado()); // Actualiza el estado si es necesario
                    existingTarea.setUsuario(tarea.getUsuario());
                    return tareaRepository.save(existingTarea);
                })
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public List<Tarea1> buscarTodo() {
        return tareaRepository.findAll();
    }

    public List<Tarea1> buscarPorEstado(boolean estado) {
        return tareaRepository.findByEstado(estado);
    }

    public void eliminarTarea(Integer id) {
        tareaRepository.deleteById(id);
    }





}
