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
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TareaRepository tareaRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Tarea1 crearTarea(Tarea1 tarea) {
        // Encuentra al usuario por ID
        Usuario usuario = usuarioRepository.findById(tarea.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Establece el usuario a la tarea
        tarea.setUsuario(usuario);
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setEstado(false); // Estado por defecto al crear

        return tareaRepository.save(tarea);
    }

    public Usuario actualizarUsuario(Integer id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setNombre(usuario.getNombre());
                    existingUsuario.setEmail(usuario.getEmail());
                    return usuarioRepository.save(existingUsuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public List<Usuario> buscarTodo() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
