package asw.edipogram.api_event.connessioni;

import asw.edipogram.api_event.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConnessioneCreatedEvent implements DomainEvent {

    @EqualsAndHashCode.Include
    Long Id;
    String utente;
    String tipo;
}
