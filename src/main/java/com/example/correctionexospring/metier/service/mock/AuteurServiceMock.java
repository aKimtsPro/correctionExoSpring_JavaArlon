package com.example.correctionexospring.metier.service.mock;

import com.example.correctionexospring.dto.AuteurDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import com.example.correctionexospring.metier.service.AuteurService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class AuteurServiceMock implements AuteurService {

    @Override
    public AuteurDTO getOne(Long aLong) throws ElementNotFoundException {
        if(aLong == 1L)
            throw new ElementNotFoundException();

        return new AuteurDTO();
    }

    @Override
    public List<AuteurDTO> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void insert(AuteurDTO toInsert) throws ElementAlreadyPresentException {
        if(toInsert.getId() == 1L)
            throw new ElementAlreadyPresentException();
    }

    @Override
    public void delete(Long aLong) throws ElementNotFoundException {
        if(aLong == 1L)
            throw new ElementNotFoundException();
    }

    @Override
    public void update(AuteurDTO toUpdate) throws ElementNotFoundException {
        if(toUpdate.getId() == 1L)
            throw new ElementNotFoundException();
    }
}
