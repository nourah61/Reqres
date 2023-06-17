package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC04_UpDateUser extends TestBase{

    @Test(priority = 1,description = "Check UpDate with valid credientials",groups = "smoke test")
    public void checkUpDateWithValidCredientials() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200).log().all().extract().response();

        // Assert Response
        Assert.assertFalse(resp.jsonPath().getString("updatedAt").isEmpty());

    }

}
