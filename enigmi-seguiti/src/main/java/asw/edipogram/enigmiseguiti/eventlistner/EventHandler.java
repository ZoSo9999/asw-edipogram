package asw.edipogram.enigmiseguiti.eventlistner;

import asw.edipogram.api_event.common.DomainEvent;
// import asw.edipogram.api_event.connessioni.ConnessioneConTipoCreatedEvent;
import asw.edipogram.api_event.enigmi.EnigmaCreatedEvent;
// import asw.edipogram.enigmiseguiti.connessioni.ConnessioneConTipo;
// import asw.edipogram.enigmiseguiti.connessioni.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.enigmi.Enigma;
import asw.edipogram.enigmiseguiti.enigmi.EnigmiServiceWebClient;
import asw.edipogram.enigmiseguiti.domain.EnigmiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class EventHandler implements IEventHandler {

    private final Logger logger = Logger.getLogger(EventHandler.class.toString());

    // @Autowired
    // private ConnessioniService connessioniService;
    @Autowired
    private EnigmiService enigmiService;
    
    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    public void onEventRaised(DomainEvent event){

        logger.info("===========================================================\n\n" +
                "PROCESSING EVENT: \n" + event +
                "\n\n=============================================================");

        if(event.getClass() == EnigmaCreatedEvent.class){
            EnigmaCreatedEvent enigmaEvent = (EnigmaCreatedEvent) event;
            Enigma enigma = this.enigmiService.addEnigma(enigmaEvent.getId(), enigmaEvent.getAutore(), enigmaEvent.getTipo(), enigmaEvent.getTipoSpecifico(), enigmaEvent.getTitolo(), enigmaEvent.getTesto());
            this.enigmiSeguitiService.onEnigmaAdded(enigma);

        // }else if(event.getClass() == ConnessioneConTipoCreatedEvent.class){
        //     ConnessioneConTipoCreatedEvent connEvent = (ConnessioneConTipoCreatedEvent) event;
        //     ConnessioneConTipo conn = this.connessioniService.createConnessioneConTipo(connEvent.getId(), connEvent.getUtente(), connEvent.getTipo());
        //     this.enigmiSeguitiService.onConnessioneConTipoAdded(conn);

        }else{
            logger.info("UNKNOWN EVENT: " + event);
        }

    }
}
