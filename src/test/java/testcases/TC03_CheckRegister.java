package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC03_CheckRegister extends TestBase{
    @Test(priority = 1,description = "Check Register with valid credientials",groups = "smoke test")
    public void checkRegisterWithValidCredientials() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .when()
                .post("/api/register")
                .then()
                .statusCode(200).log().all().extract().response();
        // Assert Response
        Assert.assertFalse(resp.jsonPath().getString("token").isEmpty());

    }

    @Test(priority = 2,description = "Check Register with unvalid credientials",groups = "smoke test")
    public void checkRegisterWithunValidCredientials() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .when()
                .post("/api/register")
                .then()
                .statusCode(400).log().all().extract().response();
        // Assert Response
        Assert.assertFalse(resp.jsonPath().getString("token").isEmpty());

    }

}
