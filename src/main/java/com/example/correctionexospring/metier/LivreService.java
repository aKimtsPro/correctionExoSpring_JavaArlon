package com.example.correctionexospring.metier;

import com.example.correctionexospring.dto.LivreDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;

import java.util.List;

public interface LivreService {

    // Read
    LivreDTO getOne(String id) throws ElementNotFoundException;
    List<LivreDTO> getAll();

    // Create
    void insert(LivreDTO toInsert) throws ElementAlreadyPresentException;

    // Delete
    void delete(String id) throws ElementNotFoundException;

    // Update
    void update(LivreDTO toUpdate) throws ElementNotFoundException;
}
