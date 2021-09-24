package com.example.correctionexospring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuteurDTO {

    private long id;
    private String prenom;
    private String nom;

    private List<LivreDTO> livresEcrit;
}
