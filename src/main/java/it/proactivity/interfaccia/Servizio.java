package it.proactivity.interfaccia;

import it.proactivity.model.ContoStandard;
import it.proactivity.model.Mutuo;

public interface Servizio {

    Float prelievo(Float importo);
    void versamento(Float importo);
    void bonifico(Float importo, ContoStandard contoStandard);


}
