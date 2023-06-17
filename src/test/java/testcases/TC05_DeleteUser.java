package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC05_DeleteUser extends TestBase{

    @Test(priority = 1,description = "Check Delete the data",groups = "smoke test")
    public void checkUpDeleteData() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204).log().all().extract().response();

    }

}
