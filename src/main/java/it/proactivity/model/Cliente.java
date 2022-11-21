package it.proactivity.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Cliente {

    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String luogoDiNascita;
    private String residenza;
    private String codiceFiscale;

    public Cliente() {}

    public Cliente(String nome, String cognome, LocalDate dataDiNascita, String luogoDiNascita, String residenza,
                   String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.luogoDiNascita = luogoDiNascita;
        this.residenza = residenza;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getLuogoDiNascita() {
        return luogoDiNascita;
    }

    public void setLuogoDiNascita(String luogoDiNascita) {
        this.luogoDiNascita = luogoDiNascita;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public String toString() {
        return "Il nome del cliente: " + nome + "\n" + "Il suo cognome: " + cognome + " \n" + "Data di nascita: " +
                dataDiNascita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome.toLowerCase(), cliente.nome.toLowerCase()) && Objects.equals(cognome.toLowerCase(),
                cliente.cognome.toLowerCase()) && Objects.equals(dataDiNascita, cliente.dataDiNascita) &&
                Objects.equals(luogoDiNascita.toLowerCase(), cliente.luogoDiNascita.toLowerCase()) &&
                Objects.equals(residenza, cliente.residenza) && Objects.equals(codiceFiscale, cliente.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, dataDiNascita, luogoDiNascita, residenza, codiceFiscale);
    }
}
