package meow.soft.fnsopendata.config;

import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final CamelContext camelContext;

    @Bean
    ProducerTemplate producerTemplate() {
        return camelContext.createProducerTemplate();
    }
}
