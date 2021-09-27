package com.example.correctionexospring.metier.mapper;

import com.example.correctionexospring.dataaccess.entity.Auteur;
import com.example.correctionexospring.dataaccess.entity.Livre;
import com.example.correctionexospring.dto.AuteurDTO;
import com.example.correctionexospring.dto.LivreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuteurMapper implements Mapper<AuteurDTO, Auteur> {

    @Autowired
    private LivreMapper livreMapper;

    @Override
    public AuteurDTO entityToDto(Auteur auteur) {
        if( auteur == null)
            return null;

        return AuteurDTO.builder()
                .id(auteur.getId())
                .nom(auteur.getNom())
                .prenom(auteur.getPrenom())
                .livresEcrit(
                        auteur.getOeuvres()
                                .stream()
                                .map(livreMapper::entityToSmall)
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public Auteur dtoToEntity(AuteurDTO auteurDTO) {
        if( auteurDTO == null )
            return null;

        return Auteur.builder()
                .id(auteurDTO.getId())
                .nom(auteurDTO.getNom())
                .prenom(auteurDTO.getPrenom())
                .build();
    }

}
