package it.proactivity.model;

import it.proactivity.abstractClass.ContoCorrente;
import it.proactivity.interfaccia.Servizio;

import java.util.Objects;

public class ContoStandard extends ContoCorrente implements Servizio {
    private Cliente cliente;
    private String iban;
    private Boolean fido = Boolean.FALSE;
    private Float saldo;
    private Float costoAnnuo = 120f;
    private Integer costoOperazione = 2;

    private Integer valoreMinSaldo = -500;

    public ContoStandard() {}

    public ContoStandard(Cliente cliente,String iban, Float saldo) {
        this.cliente = cliente;
        this.iban = iban;
        this.saldo = saldo;

        setSaldo(saldo-costoAnnuo);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Boolean getFido() {
        return fido;
    }

    public void setFido(Boolean fido) {
        this.fido = fido;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        if(this.saldo >=0){
            this.fido = false;
        }else{
          this.fido = true;
        }
        this.saldo = saldo;
    }

    public Float getCostoAnnuo() {
        return costoAnnuo;
    }

    public void setCostoAnnuo(Float costoAnnuo) {
        this.costoAnnuo = costoAnnuo;
    }

    public Integer getCostoOperazione() {
        return costoOperazione;
    }

    public void setCostoOperazione(Integer costoOperazione) {
        this.costoOperazione = costoOperazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContoStandard that = (ContoStandard) o;
        return Objects.equals(cliente, that.cliente)  &&
                Objects.equals(iban, that.iban) && Objects.equals(fido, that.fido) &&
                Objects.equals(saldo, that.saldo) && Objects.equals(costoAnnuo, that.costoAnnuo) &&
                Objects.equals(costoOperazione, that.costoOperazione) && Objects.equals(valoreMinSaldo, that.valoreMinSaldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, iban, fido, saldo, costoAnnuo, costoOperazione, valoreMinSaldo);
    }

    @Override
    public String toString() {
        return "Saldo: " + saldo + "\n" + "Fido: " + fido + "\n" + "Il costo annuo e' di: " + costoAnnuo;
    }

    @Override
    public Float prelievo(Float importo) {
        if (saldo >= (importo + costoOperazione)) {
            setSaldo(saldo - importo - costoOperazione);
        } else {
            if ((saldo - importo - costoOperazione) >= valoreMinSaldo) {
                setSaldo(saldo - importo - costoOperazione);
            }else {
                return 0f;
            }
        }
        return importo;
    }

    public Float prelievo(String importo) {
        Float newImporto = Float.parseFloat(importo);

        if (saldo >= (newImporto + costoOperazione)) {
            setSaldo(saldo - newImporto - costoOperazione);
        } else {
            if ((saldo - newImporto - costoOperazione) >= valoreMinSaldo) {
                setSaldo(saldo - newImporto - costoOperazione);
            }else {
                return 0f;
            }
        }
        return newImporto;
    }

    @Override
    public void versamento(Float importo) {
        setSaldo(saldo + importo - costoOperazione);
    }

    @Override
    public void bonifico(Float importo, ContoStandard contoStandard) {
        if (prelievo(importo).equals(importo)) {
            contoStandard.setSaldo(contoStandard.getSaldo() + importo);
        }
    }
    public void bonifico(Float importo, ContoOnline contoOnline) {
        if (prelievo(importo).equals(importo)) {
            contoOnline.setSaldo(contoOnline.getSaldo() + importo);
        }
    }
    public void bonifico(Float importo, ContoYoung contoYoung) {
        if (prelievo(importo).equals(importo)) {
            contoYoung.setSaldo(contoYoung.getSaldo() + importo);
        }
    }

    @Override
    public String infoConto() {
        return iban;
    }

}
