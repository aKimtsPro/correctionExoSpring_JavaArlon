package com.example.correctionexospring.metier.service.iml;

import com.example.correctionexospring.dataaccess.entity.Auteur;
import com.example.correctionexospring.dataaccess.repository.AuteurRepository;
import com.example.correctionexospring.dto.AuteurDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import com.example.correctionexospring.metier.mapper.Mapper;
import com.example.correctionexospring.metier.service.AuteurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuteurServiceImpl implements AuteurService {

    private final Mapper<AuteurDTO, Auteur> mapper;
    private final AuteurRepository repository;

    public AuteurServiceImpl(Mapper<AuteurDTO, Auteur> mapper, AuteurRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public AuteurDTO getOne(Long id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<AuteurDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(AuteurDTO toInsert) throws ElementAlreadyPresentException {

        if( repository.existsById(toInsert.getId()) )
            throw new ElementAlreadyPresentException();

        repository.save( mapper.dtoToEntity(toInsert) );

    }

    @Override
    public void delete(Long id) throws ElementNotFoundException {

        if( !repository.existsById(id) )
            throw new ElementNotFoundException();

        repository.deleteById(id);

    }

    @Override
    public void update(AuteurDTO toUpdate) throws ElementNotFoundException {

        if( !repository.existsById(toUpdate.getId()) )
            throw new ElementNotFoundException();

        repository.save( mapper.dtoToEntity(toUpdate) );

    }
}
