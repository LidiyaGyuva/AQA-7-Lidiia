package All_Practics.Practics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TryGetRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";
        /*given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);*/

        Response response = RestAssured.get("/api/users/2");
        String responseString = response.getBody().asString();
        System.out.println(responseString);

    }

}
