import  org.junit.jupiter.api.AfterAll;
import  org.junit.jupiter.api.BeforeAll;
import  org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import  io.restassured.config.JsonConfig;
import  io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import  org.evomaster.client.java.controller.expect.ExpectationHandler;
import  io.restassured.path.json.JsonPath;
import  java.util.Arrays;




/**
 * This file was automatically generated by EvoMaster on 2023-03-06T10:01:22.298178Z[GMT]
 * <br>
 * The generated test suite contains 4 tests
 * <br>
 * Covered targets: 25
 * <br>
 * Used time: 0h 5m 0s
 * <br>
 * Needed budget for current results: 100%
 * <br>
 * This file contains test cases that are likely to indicate faults.
 */
public class EvoMaster_faults_Test {

    
    private static String baseUrlOfSut = "https://restlerdemoserver.pagekite.me";
    /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
    * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
    */
    private static boolean ems = false;
    /**
    * sco - supported code oracle - checking that the response status code is among those supported according to the schema
    */
    private static boolean sco = false;
    /**
    * rso - response structure oracle - checking that the response objects match the responses defined in the schema
    */
    private static boolean rso = false;
    
    
    @BeforeAll
    public static void initClass() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;
        RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
    }
    
    
    
    
    
    
    
    
    /**
    * [test_0_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    */
    @Test @Timeout(60)
    public void test_0_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 378, " + 
                    " \"body\": \"\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/blog/posts")
                .then()
                .statusCode(201)
                .assertThat()
                .contentType("application/json")
                .body("'body'", containsString(""));
        
        
        ValidatableResponse res_1 = given().accept("application/json")
                .get(baseUrlOfSut + "/api/blog/posts?per_page=1051586687")
                .then()
                .statusCode(500)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("per_page is too large"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200, 422).contains(res_1.extract().statusCode()));
    }
    
    
    /**
    * [test_1_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    */
    @Test @Timeout(60)
    public void test_1_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .get(baseUrlOfSut + "/api/doc")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("this is the docs"));
        
        expectationHandler.expect(ems);
        
        given().accept("*/*")
                .delete(baseUrlOfSut + "/api/blog/posts/252")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
        
        ValidatableResponse res_2 = given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"body\": \"xGGVPWYbUA\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/blog/posts/809")
                .then()
                .statusCode(500)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("ID was not specified."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(204, 422).contains(res_2.extract().statusCode()));
    }
    
    
    /**
    * [test_2_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    */
    @Test @Timeout(60)
    public void test_2_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .get(baseUrlOfSut + "/api/doc")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("this is the docs"));
        
        expectationHandler.expect(ems);
        
        ValidatableResponse res_1 = given().accept("application/json")
                .get(baseUrlOfSut + "/api/doc")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("this is the docs"));
        
        expectationHandler.expect(ems);
        
        given().accept("application/json")
                .get(baseUrlOfSut + "/api/blog/posts/651")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'body'", containsString("my first blog post"));
        
        
        given().accept("application/json")
                .get(baseUrlOfSut + "/api/blog/posts?per_page=539")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'items'.size()", equalTo(539))
                .body("'items'[0].'body'", containsString("my first blog post"))
                .body("'items'[0].'checksum'", containsString("1d9c1"))
                .body("'items'[1].'body'", containsString("my first blog post"))
                .body("'items'[1].'checksum'", containsString("2c46e"))
                .body("'items'[2].'body'", containsString("my first blog post"))
                .body("'items'[2].'checksum'", containsString("4155a"))
                // Skipping assertions on the remaining 536 elements. This limit of 3 elements can be increased in the configurations
                .body("'per_page'", numberMatches(539.0))
                .body("'page'", numberMatches(10.0))
                .body("'total'", numberMatches(539.0));
        
        
        given().accept("application/json")
                .get(baseUrlOfSut + "/api/blog/posts?per_page=290")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'items'.size()", equalTo(290))
                .body("'items'[0].'body'", containsString("my first blog post"))
                .body("'items'[0].'checksum'", containsString("1d9c1"))
                .body("'items'[1].'body'", containsString("my first blog post"))
                .body("'items'[1].'checksum'", containsString("2c46e"))
                .body("'items'[2].'body'", containsString("my first blog post"))
                .body("'items'[2].'checksum'", containsString("4155a"))
                // Skipping assertions on the remaining 287 elements. This limit of 3 elements can be increased in the configurations
                .body("'per_page'", numberMatches(290.0))
                .body("'page'", numberMatches(10.0))
                .body("'total'", numberMatches(290.0));
        
        
        ValidatableResponse res_5 = given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"body\": \"J9txWjXuE4G5tpJF\", " + 
                    " \"checksum\": \"sQMqIsTsbs9Q\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/blog/posts/666")
                .then()
                .statusCode(500)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("ID was not specified."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(204, 422).contains(res_5.extract().statusCode()));
        
        given().accept("application/json")
                .get(baseUrlOfSut + "/api/blog/posts/517")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'body'", containsString("hp5iA6CgnXlqQ1GsOi"));
        
        
        ValidatableResponse res_7 = given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 5, " + 
                    " \"body\": \"1jfiepf9nTQT\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/blog/posts")
                .then()
                .statusCode(400)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("ID must be at least 1"));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(201, 422).contains(res_7.extract().statusCode()));
        
        given().accept("*/*")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 224, " + 
                    " \"body\": \"Kyl9gYRLRfx0WO\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/blog/posts/224")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
    }
    
    
    /**
    * [test_3_with500] is a part of 1 or more clusters, as defined by the selected clustering options. 
    * ErrorText_0
    */
    @Test @Timeout(60)
    public void test_3_with500() throws Exception {
        ExpectationHandler expectationHandler = expectationHandler();
        
        ValidatableResponse res_0 = given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"body\": \"RA\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/blog/posts/706")
                .then()
                .statusCode(500)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("ID was not specified."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(204, 422).contains(res_0.extract().statusCode()));
        
        given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 232, " + 
                    " \"body\": \"Sdjr6N7UWUvWZ9Ev\" " + 
                    " } ")
                .post(baseUrlOfSut + "/api/blog/posts")
                .then()
                .statusCode(201)
                .assertThat()
                .contentType("application/json")
                .body("'body'", containsString("Sdjr6N7UWUvWZ9Ev"));
        
        
        given().accept("*/*")
                .delete(baseUrlOfSut + "/api/blog/posts/968")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
        
        ValidatableResponse res_3 = given().accept("application/json")
                .delete(baseUrlOfSut + "/api/blog/posts/1538002666")
                .then()
                .statusCode(404)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("Blog post with id=1538002666 not found."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(204, 422).contains(res_3.extract().statusCode()));
        
        ValidatableResponse res_4 = given().accept("application/json")
                .contentType("application/json")
                .body(" { " + 
                    " \"body\": \"CEGEsYgiHJmnc\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/blog/posts/903")
                .then()
                .statusCode(500)
                .assertThat()
                .contentType("application/json")
                .body("'detail'", containsString("ID was not specified."));
        
        expectationHandler.expect(ems)
            .that(sco, Arrays.asList(204, 422).contains(res_4.extract().statusCode()));
        
        given().accept("*/*")
                .contentType("application/json")
                .body(" { " + 
                    " \"id\": 911, " + 
                    " \"body\": \"JYlFV1U\" " + 
                    " } ")
                .put(baseUrlOfSut + "/api/blog/posts/911")
                .then()
                .statusCode(204)
                .assertThat()
                .body(isEmptyOrNullString());
        
        
        given().accept("application/json")
                .get(baseUrlOfSut + "/api/blog/posts")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'items'.size()", equalTo(5))
                .body("'items'[0].'body'", containsString("my first blog post"))
                .body("'items'[0].'checksum'", containsString("1d9c1"))
                .body("'items'[1].'body'", containsString("my first blog post"))
                .body("'items'[1].'checksum'", containsString("2c46e"))
                .body("'items'[2].'body'", containsString("my first blog post"))
                .body("'items'[2].'checksum'", containsString("4155a"))
                // Skipping assertions on the remaining 2 elements. This limit of 3 elements can be increased in the configurations
                .body("'per_page'", numberMatches(5.0))
                .body("'page'", numberMatches(10.0))
                .body("'total'", numberMatches(5.0));
        
        
        ValidatableResponse res_7 = given().accept("application/json")
                .get(baseUrlOfSut + "/api/doc")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType("application/json")
                .body("'message'", containsString("this is the docs"));
        
        expectationHandler.expect(ems);
    }


}
