package meow.soft.fnsopendata;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FnsOpenDataApplication {

    private final ProducerTemplate template;

    public FnsOpenDataApplication(ProducerTemplate template) {
        this.template = template;
    }

    public static void main(String[] args) {

        SpringApplication.run(FnsOpenDataApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runRoute() {
        template.sendBody("direct:getFnsData", null);
    }

}
