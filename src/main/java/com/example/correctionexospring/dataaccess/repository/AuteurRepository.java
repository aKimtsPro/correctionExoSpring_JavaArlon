package com.example.correctionexospring.dataaccess.repository;

import com.example.correctionexospring.dataaccess.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}
