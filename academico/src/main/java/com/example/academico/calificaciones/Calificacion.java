package com.example.academico.calificaciones;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.List;
import com.example.academico.materias.Materia;
import com.example.academico.usuarios.Usuario;


@Entity
@Data
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private double calificacion;
    private int parcial;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @ManyToMany
    @JoinTable(
        name = "usuario_calificacion",
        joinColumns = @JoinColumn(name = "calificacion_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;
}
