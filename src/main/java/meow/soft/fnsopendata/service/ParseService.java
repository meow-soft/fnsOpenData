package meow.soft.fnsopendata.service;

import lombok.extern.log4j.Log4j2;
import meow.soft.fnsopendata.interfaces.IParseService;
import meow.soft.fnsopendata.util.SSLHelper;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ParseService implements IParseService {

    @Value("${openDataUrl}")
    private String fnsOpenDataUrl;

    @Override
    public String getUrl() {
        Document doc;
        try {
            doc = SSLHelper.getConnection(fnsOpenDataUrl).userAgent("PostmanRuntime/7.29.0").get();
        } catch (Exception e) {
            log.error("Ошибка при чтении адреса", e);
            return null;
        }
        return doc.select("#divSecondPageColumns > div.page-content__center > div:nth-child(2) > table > tbody > tr:nth-child(9) > td:nth-child(3) > a").attr("href");
        //return "https://data.nalog.ru/opendata/7707329152-address/data-14032022-structure-07142014.csv";
    }
}
