package asw.edipogram.connessioni.domain;

import asw.edipogram.api_event.common.DomainEvent;
import lombok.*;

public interface ConnessioniEventPublisher {

    public void publish(DomainEvent event);
}

