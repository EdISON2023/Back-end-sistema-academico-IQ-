package com.example.academico.materias;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Long id) {
        return materiaService.getMateriaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Materia> saveMateria(@RequestBody Materia materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.saveMateria(materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable Long id, @RequestBody Materia materia) {
        if (!materiaService.getMateriaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        materia.setId(id);
        return ResponseEntity.ok(materiaService.saveMateria(materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Long id) {
        if (!materiaService.getMateriaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        materiaService.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }
}
