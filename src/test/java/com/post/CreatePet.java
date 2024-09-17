package com.post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class CreatePet {



 @Test
 public void addAPet(){

     RestAssured.baseURI="https://petstore.swagger.io";
     RestAssured.basePath="v2/pet";

     File petFile  = new File("src/test/resources/petStore/createPet.json");
     RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petFile).when().post().then().statusCode(200).extract().response();

     Response response = RestAssured.given().accept(ContentType.JSON).when().get("/666").then().statusCode(200).extract().response();


// Print the entire response body in a pretty-printed format
     System.out.println(response.prettyPrint());
 }
















}
