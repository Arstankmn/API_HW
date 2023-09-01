package officeHours.week3.morning;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utilities.HrTestBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task1  extends HrTestBase {

    @Test
    void create_region() {
        Map<String, Object> RequestBody =new HashMap<>();
        RequestBody.put("region_id", 364);
        RequestBody.put("region_name","Test region");



        RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(RequestBody)
                .post("/regions/").prettyPeek();
    }
}
