package com.yash.api.rough;

import com.yash.api.utility.ExcelReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SprintBootFileUploadAndDownload {
    @Test
    public void FileUpload() {
        try {
            String userDir = System.getProperty("user.dir");
            ExcelReader excel = new ExcelReader(userDir + "/src/test/resources/testdata/testdata.xlsx");
            int rows = excel.getRowCount("Upload") + 1;
            int cols = excel.getColumnCount("Upload");
            String cellData;
            System.out.println("Rows: " + rows + " and columns: " + cols);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    cellData = String.valueOf(excel.getCellData("Upload", i, j));
                    System.out.println("Cell Data at i: " + i + " and j: " + j + " is: " + cellData);
                    String fileName = cellData;
                    RestAssured.baseURI = "http://localhost:8080/uploadFile";
                    File imageFile = new File(userDir + "/src/test/resources/upload-files/" + fileName);
                    Response response =
                            given()
                                    .contentType("multipart/form-data") // Set content type
                                    .multiPart("file", imageFile) // Add file
                                    .when()
                                    .post(); // POST endpoint
                    // Print response status and body
                    System.out.println("Response Code: " + response.getStatusCode());
                    System.out.println("Response Body: " + response.prettyPrint());
                }
            }


        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {

        }
    }

}

