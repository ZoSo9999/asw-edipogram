package asw.edipogram.enigmiseguiti.domain;

import asw.edipogram.enigmiseguiti.enigmi.Enigma;
import java.util.*; 

public interface EnigmiService {

	public Enigma addEnigma(Long Id, String autore, String tipo, String tipoSpecifico, String titolo, String[] testo);

	public Collection<Enigma> getEnigmiByTipo(String tipo);

}
