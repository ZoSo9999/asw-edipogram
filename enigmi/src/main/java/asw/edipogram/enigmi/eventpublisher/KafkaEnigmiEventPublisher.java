package asw.edipogram.enigmi.eventpublisher;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import asw.edipogram.api_event.common.DomainEvent;
import asw.edipogram.api_event.enigmi.EnigmiServiceEventChannel;
import asw.edipogram.enigmi.domain.EnigmiEventPublisher;

@Component
public class KafkaEnigmiEventPublisher implements EnigmiEventPublisher {

    private final Logger logger = Logger.getLogger(KafkaEnigmiEventPublisher.class.toString());
    
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;
    
    private String channel = EnigmiServiceEventChannel.channel;

    @Override
    public void publish(DomainEvent event) {
        logger.info("PUBLISHING MESSAGE: " + event + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }
}
