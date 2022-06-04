package asw.edipogram.enigmiseguiti.enigmi;

import asw.edipogram.enigmiseguiti.domain.*; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*; 
import java.util.stream.*; 

@Service 
@Primary 
public class EnigmiServiceWebClient implements EnigmiService {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;

	@Autowired
	private EnigmaRepository enigmiRepository;
	
	public Collection<Enigma> getEnigmiByTipi(Collection<String> tipi) {
		Collection<Enigma> enigmi = null; 
        Flux<Enigma> response = loadBalancedWebClient
                .get()
				.uri("http://enigmi/cercaenigmi/tipi/{tipi}", toString(tipi))
                .retrieve()
                .bodyToFlux(Enigma.class);
        try {
            enigmi = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return enigmi; 
	}	

	public Enigma addEnigma(Long Id, String autore, String tipo, String tipoSpecifico, String titolo, String[] testo) {
		Enigma enigma = new Enigma(Id, autore, tipo, tipoSpecifico, titolo, testo);
		enigma = enigmiRepository.save(enigma);
		return enigma;
	}

	public Collection<Enigma> getEnigmiByTipo(String tipo) {
		Collection<Enigma> enigmi = enigmiRepository.findByTipo(tipo);
		return enigmi;
	}



	private static String toString(Collection<String> c) {
		String result = 
			c.stream()
				.map(n -> String.valueOf(n))
				.collect(Collectors.joining(",", "", ""));
		return result; 
	}

}
