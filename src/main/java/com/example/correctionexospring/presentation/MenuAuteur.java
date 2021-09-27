package com.example.correctionexospring.presentation;

import com.example.correctionexospring.dto.AuteurDTO;
import com.example.correctionexospring.exception.ElementAlreadyPresentException;
import com.example.correctionexospring.exception.ElementNotFoundException;
import com.example.correctionexospring.metier.service.AuteurService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuAuteur {

    private final AuteurService service;
    private final Scanner sc;

    public MenuAuteur(AuteurService service, @Qualifier("sc2") Scanner sc) {
        this.service = service;
        this.sc = sc;
    }

    public void start(){
        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt(sc.nextLine());
            mapChoix(choix);
        }while (choix != 6);
    }

    private void displayMenu(){
        System.out.println("""
                --- MENU AUTEUR ---
                1 - afficher un
                2 - afficher tout
                3 - ajouter
                4 - supprimer
                5 - modifier
                6 - quitter
                """);
    }

    private void mapChoix(int choix){
        switch (choix){
            case 1 -> displayOne();
            case 2 -> displayAll();
            case 3 -> insert();
            case 4 -> delete();
            case 5 -> update();
            case 6 -> quit();
            default -> System.out.println("choix invalide");
        }
    }

    private void displayAll(){
        service.getAll()
                .forEach( System.out::println );
    }
    private void displayOne(){

        System.out.println("id de l'auteur: ");
        long id = Long.parseLong(sc.nextLine());

        try {
            System.out.println( service.getOne(id) );
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    private void insert(){

        // TODO : préciser
        System.out.println("Un faux element va être inséré");
        try {
            service.insert(new AuteurDTO());
        } catch (ElementAlreadyPresentException e) {
            System.out.println(e.getMessage());
        }

    }
    private void delete(){

        System.out.println("id de l'auteur: ");
        long id = Long.parseLong(sc.nextLine());

        try {
            service.delete(id);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private void update(){

        // TODO : préciser
        System.out.println("à implémenter");

    }
    private void quit(){

        System.out.println("au revoir!");

    }
}
