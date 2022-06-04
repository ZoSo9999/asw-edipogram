package asw.edipogram.connessioni.eventpublisher;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import asw.edipogram.api_event.common.DomainEvent;
import asw.edipogram.api_event.connessioni.ConnessioniServiceEventChannel;
import asw.edipogram.connessioni.domain.ConnessioniEventPublisher;

@Component
public class KafkaConnessioniEventPublisher implements ConnessioniEventPublisher {

    private final Logger logger = Logger.getLogger(KafkaConnessioniEventPublisher.class.toString());
    
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;
    
    private String channel = ConnessioniServiceEventChannel.channel;

    @Override
    public void publish(DomainEvent event) {
        logger.info("PUBLISHING MESSAGE: " + event + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }
}
