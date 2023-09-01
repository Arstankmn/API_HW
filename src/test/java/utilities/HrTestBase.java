package utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class HrTestBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://44.201.221.73:1000/ords/hr";
        //MyIpAddress:1000/ords/hr
    }
}
