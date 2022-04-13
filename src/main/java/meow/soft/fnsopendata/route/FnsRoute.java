package meow.soft.fnsopendata.route;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import meow.soft.fnsopendata.interfaces.ICsvService;
import meow.soft.fnsopendata.interfaces.IParseService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
@RequiredArgsConstructor
public class FnsRoute extends RouteBuilder {
    private final IParseService parseService;

    private final ICsvService csvService;

    @Override
    public void configure() {

        from("direct:getFnsData")
                .routeId("fnsRoute")
                .bean(parseService, "getUrl")
                .log("${body}")
                .setHeader("Accept", simple("*/*"))
                .setHeader("User-Agent", simple("PostmanRuntime/7.29.0"))
                .setHeader("Accept-Encoding", simple("gzip, deflate, br"))
                .setHeader("Connection", simple("keep-alive"))
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .toD("${body}")
                .to("file://./tmp/?fileName=address_data.csv")
                .log("file loaded")
                .bean(csvService, "readFromFile('tmp/address_data.csv')")
                .log("saved to db");

        System.out.println("route config");
    }

    @PostConstruct
    public void init() {
        System.out.println("post construct");
    }
}
