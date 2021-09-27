package com.example.correctionexospring.metier.service.iml;

import com.example.correctionexospring.dataaccess.repository.LivreRepository;
import com.example.correctionexospring.dto.LivreDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import com.example.correctionexospring.metier.mapper.LivreMapper;
import com.example.correctionexospring.metier.service.LivreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreServiceImpl implements LivreService {

    private final LivreMapper mapper;
    private final LivreRepository repository;

    public LivreServiceImpl(LivreMapper mapper, LivreRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public LivreDTO getOne(String id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<LivreDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(LivreDTO toInsert) throws ElementAlreadyPresentException {
        if( repository.existsById(toInsert.getIsbn()) )
            throw new ElementAlreadyPresentException();

        repository.save( mapper.dtoToEntity(toInsert) );
    }

    @Override
    public void delete(String id) throws ElementNotFoundException {
        if( !repository.existsById(id) )
            throw new ElementNotFoundException();

        repository.deleteById(id);
    }

    @Override
    public void update(LivreDTO toUpdate) throws ElementNotFoundException {
        if( !repository.existsById(toUpdate.getIsbn()) )
            throw new ElementNotFoundException();

        repository.save( mapper.dtoToEntity(toUpdate) );
    }
}
