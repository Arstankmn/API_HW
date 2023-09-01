package officeHours.week3.morning;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import officeHours.week3.morning.pojo.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.HrTestBase;
import io.restassured.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Task1  extends HrTestBase {

   static private int global_region_id; //I will make it private, I don't want to use it from the other classes.

    @Test
    void create_region() {
        Map<String, Object> RequestBody =new HashMap<>();
        RequestBody.put("region_id", 555);
        RequestBody.put("region_name","Test region");

/* we tried MAP and POJO*/
        Random random = new Random();
        int random_region_id = random.nextInt(1000)+100;
        int expected_region_id = random_region_id;

        global_region_id =expected_region_id;
        String expected_region_name ="Arstan region";
        System.out.println("expected_region_id = " + expected_region_id);


        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)

                .body(new Region(random_region_id, expected_region_name))
                .post("/regions/").prettyPeek();

        int actual_region_id = response.jsonPath().getInt("region_id");
        String actual_region_name = response.jsonPath().getString("region_name");
        System.out.println("actual_region_id = " + actual_region_id);
        Assertions.assertEquals(expected_region_id,actual_region_id);
        Assertions.assertEquals(expected_region_name, expected_region_name);


    }

    @Test
    void get_region() {

        RestAssured
                .given()
                .accept(ContentType.JSON)
                .get("/regions/"+global_region_id)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response().prettyPeek();




    }
}
