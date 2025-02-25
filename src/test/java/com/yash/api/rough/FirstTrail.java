package com.yash.api.rough;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FirstTrail {

    @Test
    public void imageFileUpload()
    {
        String userDir = System.getProperty("user.dir");
        // Base URI for the Postman Echo API
        RestAssured.baseURI = "https://postman-echo.com";
        // Path to the image file
        File imageFile = new File(userDir+"/src/test/resources/testdata/ImageOne.bmp");
        // Check if the file exists
        if (!imageFile.exists()) {
            System.out.println("Image file not found: " + imageFile.getAbsolutePath());
            return;
        }
        // Sending POST request with multipart data
        Response response = given().contentType("multipart/form-data") // Set content type
                .multiPart("file", imageFile) // Add file
                .multiPart("description", "Test image upload") // Additional form field
                .when().post("/post"); // POST endpoint
        // Print response status and body
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.prettyPrint());

    }

}
