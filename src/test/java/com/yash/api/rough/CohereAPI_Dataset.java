package com.yash.api.rough;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CohereAPI_Dataset {

    RequestSpecification httpRequest;
    Response response;

    @Test
    public void testCoherePostRequestOne() {

        RestAssured.baseURI = "https://api.cohere.com/v1/datasets";
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "CohereAPI_Datasets");
        requestParams.put("type", "embed-input");
        requestParams.put("Authorization", "Bearer g9SNYIUHVgkd5wL9X4g9EGIJLvcyp1UxuNqwzD7V");
        requestParams.put("X-Client-Name", "my-cool-project");
        requestParams.put("Content-Type", "multipart/form-data");

        requestParams.put("messages", "[{\"name\": \"CohereAPI_Datasets\",\"type\": \"embed-input\"}]");


        response = given().auth().oauth2("g9SNYIUHVgkd5wL9X4g9EGIJLvcyp1UxuNqwzD7V")
                .contentType("application/json")
                .body(requestParams.toString())
                .when()
                .post();
        System.out.println("Status Code is: " + response.statusCode());

    }


}
