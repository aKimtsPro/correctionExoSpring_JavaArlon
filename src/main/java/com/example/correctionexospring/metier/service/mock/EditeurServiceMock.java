package com.example.correctionexospring.metier.service.mock;

import com.example.correctionexospring.dto.EditeurDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import com.example.correctionexospring.metier.service.EditeurService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class EditeurServiceMock implements EditeurService {
    @Override
    public EditeurDTO getOne(String s) throws ElementNotFoundException {
        return null;
    }

    @Override
    public List<EditeurDTO> getAll() {
        return null;
    }

    @Override
    public void insert(EditeurDTO toInsert) throws ElementAlreadyPresentException {

    }

    @Override
    public void delete(String s) throws ElementNotFoundException {

    }

    @Override
    public void update(EditeurDTO toUpdate) throws ElementNotFoundException {

    }
}
