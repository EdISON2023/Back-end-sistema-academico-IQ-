package com.example.academico.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        return rolService.getRolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.saveRol(rol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        if (!rolService.getRolById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rol.setId(id);
        return ResponseEntity.ok(rolService.saveRol(rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        if (!rolService.getRolById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}
