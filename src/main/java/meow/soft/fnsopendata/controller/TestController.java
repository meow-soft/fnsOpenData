package meow.soft.fnsopendata.controller;

import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final ProducerTemplate producerTemplate;

    @GetMapping
    public String check() {
        producerTemplate.start();
        producerTemplate.setDefaultEndpointUri("direct:specialRoute");
        producerTemplate.sendBody("hi");
        producerTemplate.stop();
        return "Ok;";
    }
}
