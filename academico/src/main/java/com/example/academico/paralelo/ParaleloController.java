package com.example.academico.paralelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paralelos")
public class ParaleloController {

    @Autowired
    private ParaleloService paraleloService;

    @GetMapping
    public List<Paralelo> getAllParalelos() {
        return paraleloService.getAllParalelos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paralelo> getParaleloById(@PathVariable Long id) {
        return paraleloService.getParaleloById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paralelo> saveParalelo(@RequestBody Paralelo paralelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paraleloService.saveParalelo(paralelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paralelo> updateParalelo(@PathVariable Long id, @RequestBody Paralelo paralelo) {
        if (!paraleloService.getParaleloById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paralelo.setId(id);
        return ResponseEntity.ok(paraleloService.saveParalelo(paralelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParalelo(@PathVariable Long id) {
        if (!paraleloService.getParaleloById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paraleloService.deleteParalelo(id);
        return ResponseEntity.noContent().build();
    }
}
