package com.example.correctionexospring;

import com.example.correctionexospring.dto.EditeurDTO;
import com.example.correctionexospring.presentation.MenuLivre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.*;

@SpringBootApplication
public class CorrectionExoSpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CorrectionExoSpringApplication.class, args);

        MenuLivre ml = ctx.getBean(MenuLivre.class);
        ml.start();

    }

}
