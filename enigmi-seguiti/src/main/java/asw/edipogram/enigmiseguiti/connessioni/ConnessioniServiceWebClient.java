package asw.edipogram.enigmiseguiti.connessioni;

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

@Service 
@Primary 
public class ConnessioniServiceWebClient implements ConnessioniService {

    @Autowired
    private ConnessioneRepository connessioneRepository;

    public Collection<Connessione> getConnessioniByTipo(String tipo){
	    return this.connessioneRepository.findByTipo(tipo);
    }

    public Connessione addConnessione(Long Id, String utente, String tipo){
        Connessione connessione = new Connessione(Id, utente, tipo);
		connessione = connessioneRepository.save(connessione);
		return connessione;
    }
}
