package com.put;

import com.payloads.Payloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Practice {



 @Test
 public void practice(){

     RestAssured.baseURI="https://petstore.swagger.io";
     RestAssured.basePath="v2/pet";

     //1.create a pet

     RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(Payloads.getPetPayload(210,"Samimi","pooping"))
             .when().post().then().statusCode(200).extract().response();

     //2.get the pet

     RestAssured.given().contentType(ContentType.JSON)
             .when().get("/210").then().statusCode(200)
             .body("id", Matchers.is(210))
             .body("name",Matchers.equalTo("Samimi"))
             .extract().response();

     //3.update the pet
     String updatedName ="Selvi";
     RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(Payloads.getPetPayload(210,updatedName,"barking"))
             .when().put().then().statusCode(200)
             .body("id",Matchers.is(210))
             .body("name",Matchers.equalTo(updatedName))
             .extract().response();

     //get updated pet
     RestAssured.given().contentType(ContentType.JSON).when().get("/210").then().statusCode(200)
             .body("name",Matchers.equalTo(updatedName))
             .extract().response();

     //delete updated pet
     RestAssured.given().accept(ContentType.JSON).when().delete("/210").then().statusCode(200).extract().response();


 }


















}
