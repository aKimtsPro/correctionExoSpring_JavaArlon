package com.example.correctionexospring.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "editeur")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Editeur {
    @Id
    @Column(columnDefinition = "CHAR(5)")
    private String id;
    @Column(nullable = false, length = 100)
    private String nom;
    private String email;
    private String adresse;

    @OneToMany(mappedBy = "editeur",fetch = FetchType.EAGER)
    private List<Livre> livres;

}
