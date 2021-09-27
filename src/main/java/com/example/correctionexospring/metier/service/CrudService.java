package com.example.correctionexospring.metier.service;

import com.example.correctionexospring.dto.AuteurDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;

import java.util.List;

public interface CrudService<DTO, ID> {

    // Read
    DTO getOne(ID id) throws ElementNotFoundException;
    List<DTO> getAll();

    // Create
    void insert(DTO toInsert) throws ElementAlreadyPresentException;

    // Delete
    void delete(ID id) throws ElementNotFoundException;

    // Update
    void update(DTO toUpdate) throws ElementNotFoundException;

}
