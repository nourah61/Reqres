package testcases;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_GetAllUsers_GET extends TestBase{

    // TC 1 : check valid data
    @Test(priority = 1,description = "Get All Users with valid Parameters",groups = "smoke test")
    public void getAllUsersWithValidParameters(){
        // given : all inputs
        // when : action [get - post - put - delete - patch]
        // then : assert response
        Response response=given()
                .queryParam("page","2")
                //.auth().basic("","")
                .header("Accept","*/*")
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .body("data[0].id",equalTo(7))
                .log().all()// print for all response
                .extract().response();
        Assert.assertEquals(response.jsonPath().getInt("per_page"),6);
    }
    // TC2 : check request with another method
    @Test(priority = 2,description = "Get All Users with invalid Restful Method",groups = "smoke test")
    public void getAllUsersWithinValidMethod(){
        // given : all inputs
        // when : action [get - post - put - delete - patch]
        // then : assert response
        Response response=given()
                .queryParam("page","2")
                //.auth().basic("","")
                .header("Accept","*/*")
                .when()
                .post("/api/users")
                .then()
                .statusCode(405)
                .log().all()// print for all response
                .extract().response();
    }
    // TC3 : check request with invalid path
    @Test(priority = 3,description = "Get All Users with invalid URL",groups = "smoke test")
    public void getAllUsersWithinValidPath(){
        // given : all inputs
        // when : action [get - post - put - delete - patch]
        // then : assert response
        Response response=given()
                .queryParam("page","2")
                //.auth().basic("","")
                .header("Accept","*/*")
                .when()
                .get("/api/use")
                .then()
                .statusCode(404)
                .log().all()// print for all response
                .extract().response();
    }
}
