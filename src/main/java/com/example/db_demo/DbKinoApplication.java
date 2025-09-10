package com.example.db_demo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.db_demo.model.Film;
import com.example.db_demo.service.FilmMenu;
import com.example.db_demo.service.FilmService;

@SpringBootApplication
public class DbKinoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DbKinoApplication.class, args);
        final FilmService filmService = new FilmService();
        // List<Film> filme = filmService.getFilms();

        // System.out.println(filmService.getFilmByIdFilm(11L));
        // filmService.updateFilm(11L, "titel", "Matrix-3");
        // filmService.updateFilm(11L, "dauer", "150");
        // filmService.updateFilm(11L, "fsk_freigabe", "18");
        // filmService.updateFilm(11L, "inhalt", "Freedom fighters Neo, Trinity and
        // Morpheus continue to lead the revolt against the Machine Army, unleashing
        // their arsenal of extraordinary skills and weaponry against the systematic
        // forces of repression and exploitation.");
        // filmService.updateFilm(11L, "erscheinungsjahr", "2004-01-01");
        // System.out.println(filmService.getFilmByIdFilm(11L));

        // Film newFilm = new Film("Matrix-2", 140, 16, "Freedom fighters Neo, Trinity
        // and Morpheus continue to lead the revolt against the Machine Army, unleashing
        // their arsenal of extraordinary skills and weaponry against the systematic
        // forces of repression and exploitation.", LocalDate.of(2003, 1, 1));
        // filmService.saveFilm(newFilm);

        menu(filmService);
    }

    static void menu(FilmService filmService) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Bitte option wählen:");
                System.out.println("""
                        1: Film
                        2: Exit
                        """);
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> FilmMenu.showFilmMenu(filmService, scanner);
                    case 2 -> {
                        System.out.println("Exit");
                        exit = true;
                    }
                    default -> System.out.println("Ungültige Option");
                }
            }
        }
    }
}
