package com.example.correctionexospring.metier.mapper;

import com.example.correctionexospring.dataaccess.entity.Auteur;
import com.example.correctionexospring.dataaccess.entity.Editeur;
import com.example.correctionexospring.dataaccess.entity.Livre;
import com.example.correctionexospring.dto.AuteurDTO;
import com.example.correctionexospring.dto.EditeurDTO;
import com.example.correctionexospring.dto.LivreDTO;
import com.example.correctionexospring.dto.SmallLivreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LivreMapper implements Mapper<LivreDTO, Livre> {

    @Autowired
    private Mapper<EditeurDTO,Editeur> editeurMapper;
    @Autowired
    private Mapper<AuteurDTO, Auteur> auteurMapper;

    @Override
    public LivreDTO entityToDto(Livre livre) {
        if(livre == null)
            return null;

        return LivreDTO.builder()
                .isbn(livre.getIsbn())
                .titre(livre.getTitre())
                .prix(livre.getPrix())
                .editeur( editeurMapper.entityToDto(livre.getEditeur()) )
                .auteur(
                        livre.getAuteurs()
                                .stream()
                                .map( auteurMapper::entityToDto )
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public Livre dtoToEntity(LivreDTO livreDTO) {
        if(livreDTO == null)
            return null;

        return Livre.builder()
                .isbn(livreDTO.getIsbn())
                .titre(livreDTO.getTitre())
                .prix(livreDTO.getPrix())
                .editeur(editeurMapper.dtoToEntity(livreDTO.getEditeur()))
                .auteurs(
                        livreDTO.getAuteur()
                                .stream()
                                .map(auteurMapper::dtoToEntity)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public SmallLivreDTO entityToSmall(Livre livre){
        if(livre == null)
            return null;

        return SmallLivreDTO.builder()
                .isbn(livre.getIsbn())
                .titre(livre.getTitre())
                .prix(livre.getPrix())
                .build();
    }
}
