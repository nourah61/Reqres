package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_CreateUser;
import pages.PageBase;

import static io.restassured.RestAssured.*;

public class TC01_CheckCreateUser_Post extends TestBase{

     // BDD (Behavior Driven Development)
    // Given: add all inputs
    // When: add action
    // Then: assert result
    ObjectMapper mapper=new ObjectMapper();

    @Test(priority = 1,description = "Create new user with valid data",groups = "smoke test")
    public void createUserWithValidData() throws JsonProcessingException {
        // format post request
       Response resp= given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("Ahmed").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(201).log().all().extract().response();
       // Assert Response
        Assert.assertFalse(resp.jsonPath().getString("id").isEmpty());
        Assert.assertFalse(resp.jsonPath().getString("createdAt").isEmpty());
    }
    @Test(priority = 2,description = "Create new user with invalid restful method",groups = "smoke test")
    public void createUserWithinValidMethod() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("Ahmed").setJob("Tester")))
                .when()
                .get("/api/users")// change request method to another method
                .then()
                .statusCode(405).log().all().extract().response();
    }

    @Test(priority = 3,description = "Create new user with invalid path",groups = "smoke test")
    public void createUserWithinValidPath() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("Ahmed").setJob("Tester")))
                .when()
                .post("/api/user")//
                .then()
                .statusCode(404).log().all().extract().response();
    }
    @Test(priority = 4,description = "Create new user with invalid query parameter",groups = "smoke test")
    public void createUserWithinValidQueryParameter() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .queryParam("test","test")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("Ahmed").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(400).log().all().extract().response();
    }
    @Test(priority = 5,description = "Create new user with invalid autherization",groups = "smoke test")
    public void createUserWithinValidAuth() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .auth().basic("","")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("Ahmed").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(401).log().all().extract().response();
    }
    @Test(priority = 6,description = "Create new user with invalid header",groups = "smoke test")
    public void createUserWithinValidHeader() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.XML)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("Ahmed").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(400).log().all().extract().response();
    }
    @Test(priority = 7,description = "Create new user with empty username",groups = "smoke test")
    public void createUserWithinEmptyUserame() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(201).log().all().extract().response();
    }
    @Test(priority = 8,description = "Create new user with invalid minimum username",groups = "smoke test")
    public void createUserWithMinimumUserame() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("ert").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(201).log().all().extract().response();
    }
    @Test(priority = 9,description = "Create new user with Maxmimum username",groups = "smoke test")
    public void createUserWithMaximumUserame() throws JsonProcessingException {
        // format post request
        Response resp= given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(new P01_CreateUser().setName("erterter").setJob("Tester")))
                .when()
                .post("/api/users")
                .then()
                .statusCode(201).log().all().extract().response();
    }

//    @Test(priority = 1,description = "check create user with valid data",groups = "smoke test")
//    public void CheckUserCreationWithVaildData(){
//        // TODO: define request body
//        JSONObject body=new JSONObject();
//        body.put("name","Ahmed");
//        body.put("job","Tester");
//
//        // TODO: send post method
//        given().baseUri("https://reqres.in").header("Content-Type","application/json")
//                .body(body.toJSONString())
//                .when()
//                .post("/api/users").
//                then().
//                statusCode(201).
//                body("name",equalTo("Ahmed")).
//                log().all();
//    }
//
//    @Test(priority = 2,description = "check create user with valid data",groups = "smoke test")
//    public void CheckNonBDD() {
//        JSONObject body=new JSONObject();
//        body.put("name","Ahmed");
//        body.put("job","Tester");
//        RestAssured.baseURI="https://reqres.in";
//        RequestSpecification requestSpecification1 = RestAssured.given();
//        requestSpecification1.header("Content-Type","application/json");
//        requestSpecification1.body(body.toJSONString());
//       Response response = requestSpecification1.post("/api/users");
//       response.prettyPrint();
//
//    }


}
