package asw.edipogram.enigmi.domain;
import asw.edipogram.api_event.common.DomainEvent;

public interface EnigmiEventPublisher {

    public void publish(DomainEvent event);
}
