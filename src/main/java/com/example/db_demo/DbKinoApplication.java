package com.example.db_demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.db_demo.config.DBConfig;
import com.example.db_demo.model.Film;
import com.example.db_demo.service.FilmService;

@SpringBootApplication
public class DbKinoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DbKinoApplication.class, args);
        final FilmService filmService = new FilmService();
        List<Film> filme = filmService.getFilms();
    }

}
