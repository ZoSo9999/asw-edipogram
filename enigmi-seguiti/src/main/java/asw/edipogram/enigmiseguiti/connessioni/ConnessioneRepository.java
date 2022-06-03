package asw.edipogram.enigmiseguiti.connessioni;


import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ConnessioneRepository extends CrudRepository<Connessione, Long> {

    public Collection<Connessione> findByUtente(String utente);
    public Collection<Connessione> findByTipo(String tipo);
}
