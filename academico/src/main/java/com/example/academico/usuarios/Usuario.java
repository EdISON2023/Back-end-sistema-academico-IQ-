package com.example.academico.usuarios;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.util.Date;
import java.util.List;
import com.example.academico.cursos.Curso;
import com.example.academico.roles.Rol;
import com.example.academico.materias.Materia;

@Entity
@Data
public class Usuario {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String especialidad;
    private String correoElectronico;
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToMany
    @JoinTable(
        name = "usuario_curso",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;
    

    @ManyToMany
    @JoinTable(
        name = "usuario_materia",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias;

}
