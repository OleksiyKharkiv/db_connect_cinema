package com.example.db_demo.service;

import com.example.db_demo.model.Film;
import com.example.db_demo.service.FilmService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmMenu {

    public static void showFilmMenu(FilmService filmService, Scanner scanner) throws SQLException {
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
                    scanner.nextLine(); // fix buffer
                    String titel = scanner.nextLine();

                    System.out.println("Dauer:");
                    int dauer = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("FSK:");
                    int fsk = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Inhalt:");
                    String inhalt = scanner.nextLine();

                    System.out.println("Erscheinungsjahr (YYYY-MM-DD):");
                    String erscheinungsjahr = scanner.nextLine();

                    Film newFilm = new Film(titel, dauer, fsk, inhalt, LocalDate.parse(erscheinungsjahr));
                    filmService.saveFilm(newFilm);
                }
                case 4 -> {
                    System.out.println("Bitte geben Sie den Namen des Films ein, den Sie bearbeiten möchten:");
                    scanner.nextLine(); // fix buffer
                    List<Film> f = new ArrayList<>();
                    try {
                        f = filmService.getFilmsByName(scanner.nextLine());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    f.forEach(System.out::println);
                    System.out.println("Film bearbeiten:");
                    System.out.println("Bitte Film ID eingeben:");
                    // TODO: Film bearbeiten implementieren
                }
                case 5 -> {
                    System.out.println("Bitte geben Sie die ID des Films ein, den Sie löschen möchten:");
                    Long id = scanner.nextLong();
                    String result = filmService.deleteFilmById(id);
                    System.out.println(result);
                }
                case 6 -> backToMenu = true; // возвращаемся в главное меню
                default -> System.out.println("Ungültige Option");
            }
        }
    }
}
