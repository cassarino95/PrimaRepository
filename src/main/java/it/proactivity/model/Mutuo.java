package it.proactivity.model;

import java.util.Objects;

public class Mutuo {
    private Cliente cliente;
    private Float importo;
    private Integer numeroRate;

    public Mutuo() {}

    public Mutuo( Float importo, Integer numeroRate) {
        this.importo = importo;
        this.numeroRate = numeroRate;
    }

    public Mutuo(Cliente cliente, Float importo, Integer numeroRate) {
        this.cliente = cliente;
        this.importo = importo;
        this.numeroRate = numeroRate;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }

    public Integer getNumeroRate() {
        return numeroRate;
    }

    public void setNumeroRate(Integer numeroRate) {
        this.numeroRate = numeroRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mutuo mutuo = (Mutuo) o;
        return Objects.equals(cliente, mutuo.cliente) && Objects.equals(importo, mutuo.importo) &&
                Objects.equals(numeroRate, mutuo.numeroRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, importo, numeroRate);
    }

    @Override
    public String toString() {
        return """
                Cliente : %s,
                Importo : %s,
                NumeroRate : %s
                """.formatted(this.cliente, this.importo, this.numeroRate);
    }

    public void aperturaMutuo(Cliente cliente, Float importo, Integer rate) {
        this.setCliente(cliente);
        this.setImporto(importo);
        this.setNumeroRate(rate);
    }

    public void chiusuraMutuo(Mutuo mutuo) {
        mutuo.setCliente(null);
        mutuo.setImporto(null);
        mutuo.setNumeroRate(null);
    }

    public String pagamentorate() {
        return """
                Ogni mese devi pagare : %s
                """.formatted(this.getImporto() / this.getNumeroRate());
    }


}
