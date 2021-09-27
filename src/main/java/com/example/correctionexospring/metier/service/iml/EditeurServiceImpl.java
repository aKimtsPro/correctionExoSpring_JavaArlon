package com.example.correctionexospring.metier.service.iml;

import com.example.correctionexospring.dataaccess.repository.EditeurRepository;
import com.example.correctionexospring.dto.EditeurDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import com.example.correctionexospring.metier.mapper.EditeurMapper;
import com.example.correctionexospring.metier.service.EditeurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditeurServiceImpl implements EditeurService {

    private final EditeurMapper mapper;
    private final EditeurRepository repository;

    public EditeurServiceImpl(EditeurMapper mapper, EditeurRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public EditeurDTO getOne(String id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<EditeurDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(EditeurDTO toInsert) throws ElementAlreadyPresentException {
        if( repository.existsById(toInsert.getId()) )
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
    public void update(EditeurDTO toUpdate) throws ElementNotFoundException {
        if( !repository.existsById(toUpdate.getId()) )
            throw new ElementNotFoundException();

        repository.save( mapper.dtoToEntity(toUpdate) );
    }
}
