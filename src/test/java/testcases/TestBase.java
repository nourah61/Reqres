package testcases;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI="https://reqres.in";
    }
}
