import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class RestAssuredEchoPostmanTests {

    @Test
    @DisplayName("Метод GET")
    public void checkGetMethods() {
        getRequest();
    }

    @Test
    @DisplayName("Метод PATCH")
    public void checkPatchMethods() {
        patchRequest();
    }

    @Test
    @DisplayName("Метод PUT")
    public void checkPutMethods() {
        putRequest();
    }

    @Test
    @DisplayName("Метод DELETE")
    public void checkDeleteMethods() {
        deleteRequest();
    }

    @Test
    @DisplayName("Метод POST RAW")
    public void checkPostRawMethods() {
        postRawRequest();
    }

    @Test
    @DisplayName("Метод POST DATA")
    public void checkPostDataMethods() {
        postDataRequest();
    }

    public void getRequest() {
        given()
                .baseUri(baseURI = "https://postman-echo.com")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t174"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", Matchers.anyOf(equalTo("no-cache"), equalTo(null)))
                .body("headers.postman-token", Matchers.anyOf(
                        equalTo("a42e1c5a-b3b6-4144-8f47-f9474523fb33"),
                        equalTo(null)
                ))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }

    public void patchRequest() {

        given()
                .baseUri(baseURI = "https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .multiPart("field1", "value1")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.field1", equalTo("value1"))
                .body("headers.connection", equalTo("close"))
                .body("headers['content-type']", startsWith("multipart/form-data"))
                .body("headers['x-forwarded-proto']", equalTo("https"))
                .body("headers['x-forwarded-port']", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.accept", equalTo("*/*"))
                .body("headers['content-type']", containsString("multipart/form-data"))
                .body("headers['user-agent']", notNullValue())
                .body("headers.accept-encoding", matchesPattern("gzip\\s*,\\s*deflate"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t174"))
                .body("headers['accept']", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .log().all();
    }

    public void putRequest() {

        given()
                .baseUri(baseURI = "https://postman-echo.com")
                .body("Therapy is expensive. Popping bubble wrap is cheap. You choose")
                .contentType("text/plain")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo("Therapy is expensive. Popping bubble wrap is cheap. You choose"))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t174"))
                .body("headers.connection", equalTo("close"))
                .body("headers['content-length']", equalTo(String.valueOf(62)))
                .body("headers['x-forwarded-proto']", equalTo("https"))
                .body("headers['x-forwarded-port']", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers['content-type']", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers['user-agent']", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", Matchers.anyOf(equalTo("no-cache"), equalTo(null)))
                .body("headers.postman-token", Matchers.anyOf(
                        equalTo("9360499b-4745-4d38-9c87-3745ec5c7e1a"),
                        equalTo(null)
                ))
                .body("json", equalTo(null))
                .body("headers.accept-encoding", matchesPattern("gzip\\s*,\\s*deflate"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    public void deleteRequest() {

        given()
                .baseUri("https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("args.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers['x-request-start']", startsWith("t"))
                .body("headers.connection", equalTo("close"))
                .body("headers['content-length']", equalTo("58"))
                .body("headers['x-forwarded-proto']", equalTo("https"))
                .body("headers['x-forwarded-port']", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers['content-type']", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers['user-agent']", notNullValue())
                .body("headers['accept']", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

    public void postRawRequest() {

        given()
                .baseUri("https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("args.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers['x-request-start']", startsWith("t"))
                .body("headers.connection", equalTo("close"))
                .body("headers['content-length']", equalTo("58"))
                .body("headers['x-forwarded-proto']", equalTo("https"))
                .body("headers['x-forwarded-port']", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers['content-type']", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers['user-agent']", notNullValue())
                .body("headers['accept']", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    public void postDataRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(""))
                .body("args.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers['x-request-start']", startsWith("t"))
                .body("headers.connection", equalTo("close"))
                .body("headers['content-length']", equalTo("19"))
                .body("headers['x-forwarded-proto']", equalTo("https"))
                .body("headers['x-forwarded-port']", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .body("headers['user-agent']", notNullValue())
                .body("headers['accept']", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}