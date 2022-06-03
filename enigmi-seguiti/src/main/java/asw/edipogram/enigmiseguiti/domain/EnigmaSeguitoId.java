package asw.edipogram.enigmiseguiti.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnigmaSeguitoId implements Serializable {
    @EqualsAndHashCode.Include
    private String utente;
    @EqualsAndHashCode.Include
    private Long IdEnigma;
}
