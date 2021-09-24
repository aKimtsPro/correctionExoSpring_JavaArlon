package com.example.correctionexospring.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditeurDTO {
    private String id;
    private String nom;
    private String email;
    private String adresse;

    private List<LivreDTO> livresEdites;
}
