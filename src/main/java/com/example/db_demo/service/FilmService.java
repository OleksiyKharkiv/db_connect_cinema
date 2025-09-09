package com.example.db_demo.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.db_demo.config.DBConfig;
import com.example.db_demo.model.Film;

public class FilmService {

    private DBConfig dbConfig = new DBConfig();
    private List<Film> filme = new ArrayList<>();

    public List<Film> getFilms() throws SQLException {
        try {
            dbConfig.initDatabaseConnection();
            try (PreparedStatement statement = dbConfig.connection.prepareStatement("""
                    SELECT *
                    FROM film
                    """)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Film film = new Film(
                            resultSet.getLong("film_id"),
                            resultSet.getString("titel"),
                            resultSet.getInt("dauer"),
                            resultSet.getInt("fsk_freigabe"),
                            resultSet.getString("inhalt"),
                            LocalDate.parse(resultSet.getDate("erscheinungsjahr").toString()));
                    System.out.println(film.toString());
                    filme.add(film);
                    // int filmId = resultSet.getInt("film_id");
                    // String titel = resultSet.getString("titel");
                    // System.out.println(filmId + ": " + titel);
                }
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        } finally {
            dbConfig.closeDatabaseConnection();
        }
        return filme;
    }

    public Film saveFilm(Film film) throws SQLException {
        dbConfig.initDatabaseConnection();
        try (PreparedStatement statement = dbConfig.connection
                .prepareStatement("INSERT INTO film (titel, dauer, fsk_freigabe, inhalt, erscheinungsjahr) VALUES(\""
                        + film.getTitel() + "\","
                        + film.getDauer() + ","
                        + film.getFsk() + ","
                        + "\"" + film.getInhalt() + "\","
                        + "\"" + film.getErscheinungsDatum()
                        + "\")")) {
            // statement.setString(1, film.getTitel());
            // statement.setInt(2, film.getDauer());
            // statement.setInt(3, film.getFsk());
            // statement.setString(4, film.getInhalt());
            // statement.setDate(5, java.sql.Date.valueOf(film.getErscheinungsDatum()));
            System.out.println(statement.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public Film getFilmById(Long id) throws SQLException {
        Film film = null;
        dbConfig.initDatabaseConnection();
        try (PreparedStatement statement = dbConfig.connection
                .prepareStatement("SELECT * FROM film WHERE film_id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                film = new Film(
                        resultSet.getLong("film_id"),
                        resultSet.getString("titel"),
                        resultSet.getInt("dauer"),
                        resultSet.getInt("fsk_freigabe"),
                        resultSet.getString("inhalt"),
                        LocalDate.parse(resultSet.getDate("erscheinungsjahr").toString()));
            } else {
                throw new SQLException("Film mit der ID " + id + " nicht gefunden.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // dbConfig.closeDatabaseConnection();
        }
        return film;
    }
    public Film updateFilm(Long filmId, String attr, String value) throws SQLException {
        dbConfig.initDatabaseConnection();
        Film originalFilm = getFilmById(filmId);
        Film film = new Film(originalFilm.getFilmId(), originalFilm.getTitel(), originalFilm.getDauer(), originalFilm.getFsk(), originalFilm.getInhalt(), originalFilm.getErscheinungsDatum());
         switch (attr) {
            case "titel" -> film.setTitel(value);
            case "dauer" -> film.setDauer(Integer.parseInt(value));
            case "fsk_freigabe" -> film.setFsk(Integer.parseInt(value));
            case "inhalt" -> film.setInhalt(value);
            case "erscheinungsjahr" -> film.setErscheinungsDatum(LocalDate.parse(value));
            default -> throw new IllegalArgumentException("Ungültiges Attribut: " + attr);
        }
        try (PreparedStatement statement = dbConfig.connection
                .prepareStatement("UPDATE film SET " + attr + " = ? WHERE film_id = ?")) {
            statement.setString(1, value);
            statement.setLong(2, filmId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConfig.closeDatabaseConnection();
        }
        return film;
    }
    public List<Film> getFilmsByName(String name) throws SQLException {
        List<Film> filme = new ArrayList<>();
        try {
            dbConfig.initDatabaseConnection();
            try (PreparedStatement statement = dbConfig.connection.prepareStatement("""
                    SELECT *
                    FROM film
                    WHERE titel LIKE ?
                    """)) {
                statement.setString(1, "%"+name+"%");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Film film = new Film(
                            resultSet.getLong("film_id"),
                            resultSet.getString("titel"),
                            resultSet.getInt("dauer"),
                            resultSet.getInt("fsk_freigabe"),
                            resultSet.getString("inhalt"),
                            LocalDate.parse(resultSet.getDate("erscheinungsjahr").toString()));
                    System.out.println(film.toString());
                    filme.add(film);
                    // int filmId = resultSet.getInt("film_id");
                    // String titel = resultSet.getString("titel");
                    // System.out.println(filmId + ": " + titel);
                }
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        } finally {
            dbConfig.closeDatabaseConnection();
        }
        return filme;
    }
}
