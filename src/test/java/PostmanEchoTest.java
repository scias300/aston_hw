import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void getTest() {

        given()
                .when()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get")
                .then().log().body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    void postRawTextTest() {

        String body = "{\n" +
                "    \"test\": \"value\"\n" +
                "}";

        given()
                .contentType("text/plain")
                .body(body)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    void postFormDataTest() {

        String formBody = "foo1=bar1&foo2=bar2";

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(formBody)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));

    }

    @Test
    void putTest() {

        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(body)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    void patchTest() {

        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(body)
                .when()
                .patch("/patch")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    void deleteTest() {

        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(body)
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}
