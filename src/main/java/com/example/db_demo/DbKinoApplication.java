package com.example.db_demo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.db_demo.model.Film;
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
                        -1: Exit
                        """);
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> filmSubMenu(filmService, scanner); // вызываем подменю
                    case -1 -> {
                        System.out.println("Exit");
                        exit = true;
                    }
                    default -> System.out.println("Ungültige Option");
                }
            }
        }
    }

    static void filmSubMenu(FilmService filmService, Scanner scanner) throws SQLException {
        boolean backToMenu = false;
        while (!backToMenu) {
            System.out.println("Bitte machen Sie Ihre Wahl:");
            System.out.println("""
                    1: Alle Filme anzeigen
                    2: Film anzeigen
                    3: Film hinzufügen
                    4: Film bearbeiten
                    5: Film löschen
                    6: Zurück zum Hauptmenü
                    """);
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Alle Filme:");
                    filmService.getFilms().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("Bitte Film ID eingeben:");
                    Long filmId = scanner.nextLong();
                    System.out.println(filmService.getFilmById(filmId));
                }
                case 3 -> {
                    System.out.println("Film hinzufügen:");
                    
                    System.out.println("Titel:");
                    scanner.nextLine();
                    String titel = scanner.nextLine();

                    System.out.println("Dauer:");
                    int dauer = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println();

                    System.out.println("FSK:");
                    int fsk = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.println("Inhalt:");
                    String inhalt = scanner.nextLine();
                    System.out.println();

                    System.out.println("Erscheinungsjahr (YYYY-MM-DD):");
                    String erscheinungsjahr = scanner.nextLine();
                    System.out.println();

                    Film newFilm = new Film(titel, dauer, fsk, inhalt, LocalDate.parse(erscheinungsjahr));
                    filmService.saveFilm(newFilm);
                }

                case 4 -> {
                    // TODO: Film bearbeiten
                }
                case 5 -> {
                    // TODO: Film löschen
                }
                case 6 -> backToMenu = true; // возвращаемся в главное меню
                default -> System.out.println("Ungültige Option");
            }
        }
    }
}
