package com.example.db_demo.model;

import java.time.LocalDateTime;

public class Film {
    private long filmId;
    private String titel;
    private int dauer;
    private int fsk;
    private String inhalt;
    private LocalDateTime erscheinungsDatum;

    public Film() {}
    public Film(int filmId, String titel, int dauer, int fsk, String inhalt, LocalDateTime erscheinungsDatum) {
        this.filmId = filmId;
        this.titel = titel;
        this.dauer = dauer;
        this.fsk = fsk;
        this.inhalt = inhalt;
        this.erscheinungsDatum = erscheinungsDatum;
    }

    public long getFilmId() {
        return filmId;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel (String titel){
        this.titel = titel;
    }
}
