package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AsyncWithoutAwaitility {

    String baseUri = "https://reqres.in/api";

   /* String baseUri = "https://restful-booker.herokuapp.com";
    String baseUri2 = "http://apilayer.net/api/";
double convertRate ;



   @Test(priority = 0)
    public void getExchangeRate() {
        Map<String, String> quaryParam = new LinkedHashMap<>();
        quaryParam.put("access_key", "56dbc6c0ea62701b42a5893d08de7ff5");
        quaryParam.put("currencies", "EUR");
        quaryParam.put("source", "USD");
        quaryParam.put("format", "1");
        Response response = given()
                .queryParams(quaryParam)
                .get(baseUri2 + "/live");
        convertRate = response.jsonPath().getDouble("quotes.USDEUR");
        System.out.println(convertRate);
    }

    @Test(priority = 1)
    public void test1() {
        Map<String, String> body = new LinkedHashMap<>();
        body.put("username", "admin");
        body.put("password", "password123");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(baseUri + "/auth");
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void Test2() throws InterruptedException {
        Map<String, Object> quearyParams = new LinkedHashMap<>();
        quearyParams.put("firstname", "sally");
        quearyParams.put("lastname", "brown");
        Response response = given()
                .header("Content-Type", "application/json")
                .queryParams(quearyParams)
                .when()
                .get(baseUri + "/booking");
        Thread.sleep(4000);
        Assert.assertEquals(response.getStatusCode(), 200);
    }*/

}
