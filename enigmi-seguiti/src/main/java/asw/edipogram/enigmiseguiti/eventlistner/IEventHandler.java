package asw.edipogram.enigmiseguiti.eventlistner;

import asw.edipogram.api_event.common.DomainEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IEventHandler {

    void onEventRaised(DomainEvent event);
}
