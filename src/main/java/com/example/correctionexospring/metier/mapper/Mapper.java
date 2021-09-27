package com.example.correctionexospring.metier.mapper;

public interface Mapper<DTO, ENTITY> {

    DTO entityToDto(ENTITY entity);
    ENTITY dtoToEntity(DTO dto);

}
