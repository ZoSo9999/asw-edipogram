package asw.edipogram.enigmiseguiti.eventlistner;

import asw.edipogram.api_event.common.DomainEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventListener{

    @Autowired
    private IEventHandler eventHandler;
    
    //@KafkaListeners(value = {@KafkaListener(topics = "$(asw.edipogram.kafka.channel.events.enigmi)",
    @KafkaListeners(value = {@KafkaListener(topics = "enigmi-event-channel",
                                            groupId = "enigmi-event-consumer"),
                             @KafkaListener(topics = "connessioni-event-channel",
                                            groupId = "connessioni-event-consumer")
                        })
    public void onEventRaised(ConsumerRecord<String, DomainEvent> record) {
        DomainEvent event = record.value();
        this.eventHandler.onEventRaised(event);
    }
}
