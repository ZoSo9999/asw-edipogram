package asw.edipogram.enigmiseguiti.domain;

import asw.edipogram.enigmiseguiti.enigmi.Enigma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(EnigmaSeguitoId.class)
public class EnigmaSeguito implements Comparable<EnigmaSeguito>{

    @Id
    @EqualsAndHashCode.Include
    String utente;
    @Id
    @EqualsAndHashCode.Include
    Long IdEnigma;
    String autoreEnigma;
    String tipoEnigma;
    String tipoSpecificoEnigma;
    String titoloEnigma;
    String[] testoEnigma;

    public EnigmaSeguito(String utente, Enigma enigma){
        this(utente, enigma.getId(), enigma.getAutore(), enigma.getTipo(), enigma.getTipoSpecifico(), enigma.getTitolo(), enigma.getTesto());
    }
    
    @Override
	public int compareTo(EnigmaSeguito other) {
		return this.IdEnigma.compareTo(other.IdEnigma); 
	}
	
}
