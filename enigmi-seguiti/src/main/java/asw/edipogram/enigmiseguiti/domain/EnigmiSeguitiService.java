package asw.edipogram.enigmiseguiti.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import asw.edipogram.enigmiseguiti.enigmi.Enigma;
import asw.edipogram.enigmiseguiti.enigmi.EnigmiServiceWebClient;
import asw.edipogram.enigmiseguiti.connessioni.Connessione;

import java.util.*; 
import java.util.stream.*; 

@Service 
public class EnigmiSeguitiService {

	@Autowired 
	private ConnessioniService connessioniService;

	@Autowired 
	private EnigmiService enigmiService;

	@Autowired
	private EnigmiSeguitiRepository enigmiSeguitiRepository;

	/* Trova gli enigmi (in formato breve) degli utenti seguiti da utente. */ 
	public Collection<Enigma> getEnigmiSeguiti(String utente) {
		Collection<Enigma> enigmiSeguiti = new TreeSet<>(); 
		Collection<Connessione> connessioni = connessioniService.getConnessioniByUtente(utente); 
		Collection<String> tipiSeguiti = 
			connessioni
				.stream()
				.map(c -> c.getTipo())
				.collect(Collectors.toSet()); 
		if (tipiSeguiti.size()>0) {
			Collection<Enigma> enigmi = enigmiService.getEnigmiByTipi(tipiSeguiti);
			enigmiSeguiti.addAll(enigmi); 
		}
		return enigmiSeguiti; 
	}

	public void onEnigmaAdded(Enigma enigma) {
		Collection<EnigmaSeguito> newSeguitiSet = new TreeSet<>();
		
		Collection<Connessione> connessioni = this.connessioniService.getConnessioniByTipo(enigma.getTipo());
		for(Connessione c : connessioni){
			EnigmaSeguito e = new EnigmaSeguito(c.getUtente(), enigma);
			newSeguitiSet.add(e);
		}
		this.enigmiSeguitiRepository.saveAll(newSeguitiSet);
	}

}
