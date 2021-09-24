package com.example.correctionexospring.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivreDTO {

    private String isbn;
    private String titre;
    private double prix;

    private List<AuteurDTO> auteur;

    private EditeurDTO editeur;
}
