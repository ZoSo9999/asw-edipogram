package asw.edipogram.enigmiseguiti.connessioni;

import javax.persistence.*; 

import lombok.*; 

@Entity 
@Data @NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Connessione {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long id; 
	private String utente; 
	private String tipo; 
	
}
