package com.example.correctionexospring.metier;

import com.example.correctionexospring.dto.LivreDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivreServiceMock implements LivreService {
    @Override
    public LivreDTO getOne(String id) throws ElementNotFoundException {
        return null;
    }

    @Override
    public List<LivreDTO> getAll() {
        return null;
    }

    @Override
    public void insert(LivreDTO toInsert) throws ElementAlreadyPresentException {

    }

    @Override
    public void delete(String id) throws ElementNotFoundException {

    }

    @Override
    public void update(LivreDTO toUpdate) throws ElementNotFoundException {

    }
}
