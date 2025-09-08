package com.example.db_demo.model;

public class Film {
    private int film_id;
    private String titel;
    private int dauer;
    private int fsk;
    private String inhalt;
    private LocalDateTime erscheinungsdatum;
    public Film() {}

    public Film(int film_id, String titel, int dauer, int fsk, String inhalt, LocalDateTime erscheinungsdatum) {
        this.film_id = film_id;
        this.titel = titel;
        this.dauer = dauer;
        this.fsk = fsk;
        this.inhalt = inhalt;
        this.erscheinungsdatum = erscheinungsdatum;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }
}
