package com.example.correctionexospring.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livre {

    @Id
    @Column(columnDefinition = "CHAR(13)")
    private String isbn;

    @Column(unique = true, nullable = false)
    private String titre;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double prix;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cree_par",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "auteur_id")
    )
    private List<Auteur> auteurs;

    @ManyToOne
    @JoinColumn(name = "editeur")
    private Editeur editeur;

}
