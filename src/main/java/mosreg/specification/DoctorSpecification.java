package mosreg.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DoctorSpecification {
    private final String BASE_URL = "https://zdrav.mosreg.ru/api/v2/emias/iemk/doctors";

    public final RequestSpecification GET_DOCTORS_LIST =
            new RequestSpecBuilder()
                    .setBaseUri(BASE_URL)
                    .setContentType(ContentType.JSON)
                    .build();
}