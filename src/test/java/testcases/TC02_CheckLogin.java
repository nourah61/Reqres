package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_CreateUser;

import static io.restassured.RestAssured.given;

public class TC02_CheckLogin extends TestBase{

    @Test(priority = 1,description = "Check Login with valid credientials",groups = "smoke test")
    public void checkLoginWithValidCredientials() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .when()
                .post("/api/login")
                .then()
                .statusCode(200).log().all().extract().response();
        // Assert Response
        Assert.assertFalse(resp.jsonPath().getString("token").isEmpty());

    }
    @Test(priority = 2,description = "Check Login with invalid credientials",groups = "smoke test")
    public void checkLoginWithinValidCredientials() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"citysa\"\n" +
                        "}")
                .when()
                .post("/api/login")
                .then()
                .statusCode(400).log().all().extract().response();
        // Assert Response
        Assert.assertFalse(resp.jsonPath().getString("token").isEmpty());

    }
}
