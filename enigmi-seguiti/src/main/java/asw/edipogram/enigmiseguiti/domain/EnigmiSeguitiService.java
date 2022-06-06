package asw.edipogram.enigmiseguiti.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import asw.edipogram.enigmiseguiti.enigmi.Enigma;
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
		Collection<Enigma> enigmi=  new TreeSet<>();
		Collection<EnigmaSeguito> enigmiseguiti = this.enigmiSeguitiRepository.findByUtente(utente);
		for (EnigmaSeguito e : enigmiseguiti){
			Enigma enigma = new Enigma(e.getIdEnigma(),e.getAutoreEnigma(),e.getTipoEnigma(),e.getTipoSpecificoEnigma(),e.getTitoloEnigma(),e.getTestoEnigma());
			enigmi.add(enigma);
		}
		return enigmi; 
	}

	public void onEnigmaAdded(Enigma enigma) {
		
		Collection<Connessione> connessioni = this.connessioniService.getConnessioniByTipo(enigma.getTipo());
		for(Connessione c : connessioni){
			EnigmaSeguito e = new EnigmaSeguito(c.getUtente(), enigma);
			this.enigmiSeguitiRepository.save(e);
		}
	}

	public void onConnessioneAdded(Connessione connessione){

		Collection<Enigma> enigmi = this.enigmiService.getEnigmiByTipo(connessione.getTipo());
		for (Enigma e : enigmi){
			EnigmaSeguito es = new EnigmaSeguito(connessione.getUtente(), e);
			this.enigmiSeguitiRepository.save(es);
		}
	}

}
