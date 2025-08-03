package br.biblioteca.project.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class LivrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer numPag;
}
