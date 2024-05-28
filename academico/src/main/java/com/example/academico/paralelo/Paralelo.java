package com.example.academico.paralelo;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.example.academico.cursos.Curso;

@Entity
@Data
public class Paralelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String paralelo;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;
}
