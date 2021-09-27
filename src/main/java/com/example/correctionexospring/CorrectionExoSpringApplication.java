package com.example.correctionexospring;

import com.example.correctionexospring.dataaccess.entity.Editeur;
import com.example.correctionexospring.dataaccess.entity.Livre;
import com.example.correctionexospring.dto.EditeurDTO;
import com.example.correctionexospring.dto.LivreDTO;
import com.example.correctionexospring.metier.mapper.LivreMapper;
import com.example.correctionexospring.presentation.MenuAuteur;
import com.example.correctionexospring.presentation.MenuEditeur;
import com.example.correctionexospring.presentation.MenuLivre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

@SpringBootApplication
public class CorrectionExoSpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CorrectionExoSpringApplication.class, args);

        MenuLivre ml = ctx.getBean(MenuLivre.class);
        ml.start();

        MenuAuteur ma = ctx.getBean(MenuAuteur.class);
        ma.start();

        MenuEditeur me = ctx.getBean(MenuEditeur.class);
        me.start();


    }

}
