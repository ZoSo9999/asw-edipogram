package asw.edipogram.enigmiseguiti.enigmi;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EnigmaRepository extends CrudRepository<Enigma, Long>{
    
    Collection<Enigma> findByAutore(String autore);

    Collection<Enigma> findByTipoStartingWith(String tipo);
}
