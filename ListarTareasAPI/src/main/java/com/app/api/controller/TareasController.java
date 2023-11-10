package com.app.api.controller;

import com.app.api.domain.Tarea;
import com.app.api.domain.TareaServicios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    private TareaServicios tareaServicios;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaServicios.listarTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTaskById(@PathVariable Long id) {
        Tarea tarea = tareaServicios.listarTareabyId(id);
        return tarea != null ? ResponseEntity.ok(tarea) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Tarea> crearTarea(@RequestBody @Valid Tarea tarea) {
        Tarea TareaCreada = tareaServicios.crearTarea(tarea);
        return new ResponseEntity<>(TareaCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        if (tareaServicios.listarTareabyId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        tarea.setId(id);
        Tarea tareaActualizada = tareaServicios.actualizarTarea(tarea);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (tareaServicios.listarTareabyId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        tareaServicios.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }

}

