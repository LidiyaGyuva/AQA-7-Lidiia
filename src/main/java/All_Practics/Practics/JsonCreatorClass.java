package All_Practics.Practics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class JsonCreatorClass {

    public static void main(String[] args) {

        /*{
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}*/

        JSONObject fullBody = new JSONObject();

        fullBody.put("id", 12366);
        JSONObject categoryObject = new JSONObject();
        categoryObject.put("id", 12366);
        categoryObject.put("name", "Cat");

        fullBody.put("category", categoryObject);
        fullBody.put("name", "Barsik");

        JSONArray photoUrl = new JSONArray();
        photoUrl.add("url1");
        photoUrl.add("url2");
        fullBody.put("photoURL", photoUrl);

        JSONArray arrayOfTags = new JSONArray();
        JSONObject tag1 = new JSONObject();
        tag1.put("id", 5);
        tag1.put("name", "MytagCat");

        JSONObject tag2 = new JSONObject();
        tag2.put("id", 8);
        tag2.put("name", "MyTagDog");
        arrayOfTags.add(tag1);
        arrayOfTags.add(tag2);

        fullBody.put("tags", arrayOfTags);
        fullBody.put("status", "avaiable");


        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(fullBody)
                .when()
                .post("/pet");

        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();
        System.out.println(responseBody);
        System.out.println(statusCode);

    }
}
