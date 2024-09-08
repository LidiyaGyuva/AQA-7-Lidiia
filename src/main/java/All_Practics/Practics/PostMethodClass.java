package All_Practics.Practics;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostMethodClass {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("api/users");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        JsonObject responseObject = JsonParser.parseString(responseBody).getAsJsonObject();
        String dataCreation = responseObject.get("createdAt").getAsString();
        System.out.println("Data creation " + dataCreation);


    }
}
