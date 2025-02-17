package mosreg.service;

import io.restassured.response.Response;
import mosreg.model.doctor.Doctors;
import mosreg.model.doctor.Items;
import mosreg.specification.DoctorSpecification;

import javax.mail.FetchProfile;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class DoctorService {
    private final DoctorSpecification specification = new DoctorSpecification();
    private static final String NUMBER = "5097579792000180";
    private static final String BIRTH_DAY = "2024-02-07";
    private static final Long DEPARTMENT_ID = 49L;
    private static final Long DAYS = 21L;

//    https://zdrav.mosreg.ru/api/v2/emias/iemk/doctors?number=5097579792000180&birthday=2024-02-07&departmentId=49&days=21


    public List<Items> getDoctorsList() {
        return getDoctorsListResponse()
                .then()
                .extract().body()
                .jsonPath().getList("items", Items.class);
    }

    private Response getDoctorsListResponse() {
        return given()
                .relaxedHTTPSValidation()
                .spec(specification.GET_DOCTORS_LIST)
                .queryParam("number", NUMBER)
                .queryParam("birthday", BIRTH_DAY)
                .queryParam("departmentId", DEPARTMENT_ID)
                .queryParam("days", DAYS)
                .when()
                .get();
    }

}