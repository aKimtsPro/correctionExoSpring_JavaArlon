package com.example.correctionexospring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SmallLivreDTO {

    private String isbn;
    private String titre;
    private double prix;

}
