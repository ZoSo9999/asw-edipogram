package asw.edipogram.enigmiseguiti.config;

import asw.edipogram.enigmiseguiti.eventlistner.EventHandler;
import asw.edipogram.enigmiseguiti.eventlistner.IEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlerConfig {

    @Bean
    public IEventHandler getHandler(){
        return new EventHandler();
    }
}
