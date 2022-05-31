package asw.edipogram.api_event.enigmi;


import asw.edipogram.api_event.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnigmaCreatedEvent implements DomainEvent {

    @EqualsAndHashCode.Include
    Long Id;
    String autore;
    String tipo;
    String titolo;
    String[] testo;
}
