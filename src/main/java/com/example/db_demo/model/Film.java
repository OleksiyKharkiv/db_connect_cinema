package com.example.db_demo.model;

import java.time.LocalDate;

public class Film {
    private Long filmId;
    private String titel;
    private int dauer;
    private int fsk;
    private String inhalt;
    private LocalDate erscheinungsDatum;

    public Film() {
    }

    public Film(Long filmId, String titel, int dauer, int fsk, String inhalt, LocalDate erscheinungsDatum) {
        this.filmId = filmId;
        this.titel = titel;
        this.dauer = dauer;
        this.fsk = fsk;
        this.inhalt = inhalt;
        this.erscheinungsDatum = erscheinungsDatum;
    }

    public Long getFilmId() {
        return filmId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getFsk() {
        return fsk;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public LocalDate getErscheinungsDatum() {
        return erscheinungsDatum;
    }

    public void setErscheinungsDatum(LocalDate erscheinungsDatum) {
        this.erscheinungsDatum = erscheinungsDatum;
    }

    @Override
    public String toString() {
        return "Film {" +
                "filmId=" + this.getFilmId() +
                ", Titel =" + this.getTitel() +
                ", Dauer =" + this.getDauer() +
                ", FSK =" + this.getFsk() +
                ", Inhalt =" + this.getInhalt() +
                ", Erscheinungsdatum =" + this.getErscheinungsDatum() +
                "}";
    }
}
