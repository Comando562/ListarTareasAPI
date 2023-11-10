package com.app.api.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicios {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    public List<Tarea> listarTareas() {
        return (List<Tarea>) tareaRepositorio.findAll();
    }

    public Tarea listarTareabyId(Long id) {
        return tareaRepositorio.findById(id).orElse(null);
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepositorio.save(tarea);
    }

    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepositorio.save(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepositorio.deleteById(id);
    }
}
