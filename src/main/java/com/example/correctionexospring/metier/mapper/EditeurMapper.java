package com.example.correctionexospring.metier.mapper;

import com.example.correctionexospring.dataaccess.entity.Editeur;
import com.example.correctionexospring.dataaccess.entity.Livre;
import com.example.correctionexospring.dto.EditeurDTO;
import com.example.correctionexospring.dto.LivreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EditeurMapper implements Mapper<EditeurDTO, Editeur> {

    @Autowired
    private LivreMapper livreMapper;


    @Override
    public EditeurDTO entityToDto(Editeur editeur) {
        if( editeur == null )
            return null;

        return EditeurDTO.builder()
                .id(editeur.getId())
                .nom(editeur.getNom())
                .adresse(editeur.getAdresse())
                .email(editeur.getEmail())
                .livresEdites(
                        editeur.getLivres()
                                .stream()
                                .map(livreMapper::entityToSmall)
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public Editeur dtoToEntity(EditeurDTO editeurDTO) {
        if( editeurDTO == null )
            return null;

        return Editeur.builder()
                .id(editeurDTO.getId())
                .nom(editeurDTO.getNom())
                .adresse(editeurDTO.getAdresse())
                .email(editeurDTO.getEmail())
                .build();
    }
}
