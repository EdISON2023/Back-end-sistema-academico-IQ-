package com.example.academico.calificaciones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public List<Calificacion> getAllCalificaciones() {
        return calificacionService.getAllCalificaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> getCalificacionById(@PathVariable Long id) {
        return calificacionService.getCalificacionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Calificacion> saveCalificacion(@RequestBody Calificacion calificacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.saveCalificacion(calificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> updateCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        if (!calificacionService.getCalificacionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        calificacion.setId(id);
        return ResponseEntity.ok(calificacionService.saveCalificacion(calificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalificacion(@PathVariable Long id) {
        if (!calificacionService.getCalificacionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        calificacionService.deleteCalificacion(id);
        return ResponseEntity.noContent().build();
    }
}
