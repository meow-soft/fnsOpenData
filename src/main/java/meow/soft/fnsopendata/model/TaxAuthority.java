package meow.soft.fnsopendata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Территориальный налоговый орган
 */
@Document(collection = "tnos")
@Data
public class TaxAuthority {
    @Id
    private String id;

    @Indexed(unique = true)
    @JsonProperty("GA")
    private String code;

    @JsonProperty("GB")
    private String title;

    @JsonProperty("G1")
    private String address;

    @JsonProperty("G2")
    private String phone;

    @JsonProperty("G3")
    private String additionalInfo;

    @JsonProperty("G4")
    private String paymentReceiver;

    @JsonProperty("G5")
    private String oktmo;

    @JsonProperty("G6")
    private String inn;

    @JsonProperty("G7")
    private String kpp;

    @JsonProperty("G8")
    private String bankTitle;

    @JsonProperty("G9")
    private String bik;

    @JsonProperty("G10")
    private String correspondentAccount;

    @JsonProperty("G11")
    private String account;

    @JsonProperty("G12")
    private String registrationAuthorityCode;

    @JsonProperty("G13")
    private String title_2;

    @JsonProperty("G14")
    private String address_2;

    @JsonProperty("G15")
    private String phone_2;

    @JsonProperty("G16")
    private String additionalInfo_2;

    @JsonProperty("G17")
    private String registrationAuthorityCode_2;

    @JsonProperty("G18")
    private String title_3;

    @JsonProperty("G19")
    private String address_3;

    @JsonProperty("G20")
    private String phone_3;

    @JsonProperty("G21")
    private String additionalInfo_3;
}
