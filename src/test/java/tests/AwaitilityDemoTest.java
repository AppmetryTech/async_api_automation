package tests;

import io.restassured.response.Response;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class AwaitilityDemoTest {
    String baseUri = "https://reqres.in/api";
    Response response;
    public int createUser() {
        int randomNumber = (int) ((Math.random() * 50) + 1);
        Map<String, String> reqeustBody = new LinkedHashMap<>();
        reqeustBody.put("name", "TEST USER");
        reqeustBody.put("job", "QA");
        System.out.println("Random Number --> " + randomNumber);
        if (randomNumber % 2 == 0) {
            System.out.println("User created....");
            return given()
                    .body(reqeustBody)
                    .post(baseUri + "/users")
                    .statusCode();
        } else {
            System.out.println("User not created retrying ....");
            return 0;
        }

    }
    @Test(priority = 1)
    public void validateStatusCode() {
        Awaitility
                .await()
                .atMost(Duration.ofSeconds(10))
                .pollInterval(Duration.ofSeconds(2))
                .until(() -> createUser() == 201);
    }

    public Response createUser1() {
        int randomNumber = (int) ((Math.random() * 50) + 1);
        Map<String, String> reqeustBody = new LinkedHashMap<>();
        reqeustBody.put("name", "TEST USER");
        reqeustBody.put("job", "QA");
        System.out.println("Random Number --> " + randomNumber);
        if (randomNumber % 2 == 0) {
            System.out.println("User created....");
            return given()
                    .body(reqeustBody)
                    .post(baseUri + "/users");
        } else {
            System.out.println("User not created retrying ....");
            return null;
        }

    }

    @Test(priority = 2)
    public void extractResponse() {
        Awaitility
                .await()
                .atLeast(Duration.ofMillis(100))
                .atMost(Duration.ofSeconds(10))
                .pollInterval(Duration.ofMillis(100))
                .until(() -> {
                    response = createUser1();
                    if (response != null)
                        return true;
                    else
                        return false;
                });

        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(),201);
    }
}
