package it.proactivity.bancaMain;

import it.proactivity.model.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class BancaMain {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Andrea", "Rossi", dateOfBirthday(2000, 2, 20),
                "Milano", "Milano", "asdf1233");

        ContoStandard contoStandard = new ContoStandard(cliente,"snhishcihi",1000f);
        ContoOnline contoOnline = new ContoOnline(cliente,"heisy837",500000f);
        ContoYoung contoYoung = new ContoYoung(cliente,"kj99y28hd",2000f);



        contoStandard.bonifico(1000f,contoYoung);
        contoStandard.bonifico(100f,contoStandard);
        contoStandard.bonifico(100f,contoOnline);

        Mutuo mutuo = new Mutuo();
        mutuo.aperturaMutuo(cliente,100000f,19);
        System.out.println(mutuo);


        System.out.println(mutuo.pagamentorate());


    }

    public static LocalDate dateOfBirthday(Integer anno, Integer mese, Integer giorno) {
        LocalDate localDate = LocalDate.of(anno, mese, giorno);
        return localDate;
    }
}
