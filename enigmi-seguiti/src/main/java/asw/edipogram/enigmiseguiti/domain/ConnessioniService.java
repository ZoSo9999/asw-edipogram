package asw.edipogram.enigmiseguiti.domain;

import java.util.*;

import asw.edipogram.enigmiseguiti.connessioni.Connessione; 

public interface ConnessioniService {

	public Collection<Connessione> getConnessioniByUtente(String utente); 

	public Collection<Connessione> getConnessioniByTipo(String tipo);

	public Connessione addConnessione(Long Id, String utente, String tipo);
	
}
