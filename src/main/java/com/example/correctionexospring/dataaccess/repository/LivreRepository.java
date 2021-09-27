package com.example.correctionexospring.dataaccess.repository;

import com.example.correctionexospring.dataaccess.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, String> {
}
