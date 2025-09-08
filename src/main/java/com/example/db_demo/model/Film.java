package com.example.db_demo.model;

import java.time.LocalDateTime;

public class Film {
    private long filmId;
    private String titel;
    private int dauer;
    private int fsk;
    private String inhalt;
    private LocalDateTime erscheinungsDatum;

    public Film() {
    }

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

    public LocalDateTime getErscheinungsDatum() {
        return erscheinungsDatum;
    }

    public void setErscheinungsDatum(LocalDateTime erscheinungsDatum) {
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
