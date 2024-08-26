package com.example.demoFinal.repository;

import com.example.demoFinal.model.Tarea1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea1,Integer> {
    List<Tarea1> findByEstado(boolean estado);
}
