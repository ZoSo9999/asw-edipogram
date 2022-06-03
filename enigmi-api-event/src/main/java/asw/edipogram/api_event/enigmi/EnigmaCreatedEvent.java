package asw.edipogram.api_event.enigmi;


import asw.edipogram.api_event.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
// @AllArgsConstructor
// @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnigmaCreatedEvent implements DomainEvent {

    @EqualsAndHashCode.Include
    Long Id;
    String autore;
    String tipo;
    String tipoSpecifico;
    String titolo;
    String[] testo;

    public EnigmaCreatedEvent(){}
    public EnigmaCreatedEvent(Long Id, String autore, String tipo, String tipoSpecifico, String titolo, String[] testo){
        this();
        this.Id=Id;
        this.autore = autore;
        this.tipo = tipo;
        this.tipoSpecifico = tipoSpecifico;
        this.titolo = titolo;
        this.testo = testo;
    }
}

