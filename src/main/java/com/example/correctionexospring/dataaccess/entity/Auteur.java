package com.example.correctionexospring.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @ManyToMany(mappedBy = "auteurs", fetch = FetchType.EAGER)
    private List<Livre> oeuvres;

}
