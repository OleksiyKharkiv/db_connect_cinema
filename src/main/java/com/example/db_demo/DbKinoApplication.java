package com.example.db_demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.db_demo.config.DBConfig;

@SpringBootApplication
public class DbKinoApplication {

	public static void main(String[] args) throws SQLException {
        SpringApplication.run(DbKinoApplication.class, args);

        DBConfig dbConfig = new DBConfig();
        try {
            dbConfig.initDatabaseConnection();

            try (PreparedStatement statement = dbConfig.connection.prepareStatement("""
				SELECT *
				FROM film
				LIMIT 10""")) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int filmId = resultSet.getInt("film_id");
                    String titel = resultSet.getString("titel");
                    System.out.println(filmId + ": " + titel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // лучше выводить стек
        } finally {
            dbConfig.closeDatabaseConnection();
        }
    }

}
