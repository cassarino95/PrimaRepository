package it.proactivity.model;

import it.proactivity.myEnum.ValoreRischio;

import java.util.Objects;

public class Trading {
    private ValoreRischio valoreRischio;
    private Cliente cliente;
    private Float capitale;
    private Integer interesse;

    public Trading() {}

    public Trading(ValoreRischio valoreRischio, Cliente cliente, Float capitale, Integer interesse) {
        this.valoreRischio = valoreRischio;
        this.cliente = cliente;
        this.capitale = capitale;
        this.interesse = interesse;
    }

    public ValoreRischio getValoreRischio() {
        return valoreRischio;
    }

    public void setValoreRischio(ValoreRischio valoreRischio) {
        this.valoreRischio = valoreRischio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getCapitale() {
        return capitale;
    }

    public void setCapitale(Float capitale) {
        this.capitale = capitale;
    }

    public Integer getInteresse() {
        return interesse;
    }

    public void setInteresse(Integer interesse) {
        this.interesse = interesse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trading trading = (Trading) o;
        return valoreRischio == trading.valoreRischio && Objects.equals(cliente, trading.cliente) &&
                Objects.equals(capitale, trading.capitale) && Objects.equals(interesse, trading.interesse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valoreRischio, cliente, capitale, interesse);
    }

    @Override
    public String toString() {
        return """
                Cliente : %s,
                Valore di rischio : %s,
                Capitale : %s,
                Interesse : %s
                """.formatted(this.cliente, this.valoreRischio, this.capitale, this.interesse);
    }

}
