package com.airportToken;

import com.payloads.Payloads;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.Map;

public class GenerateToken {


 @Test
 public void generateAndUseToken(){

     RestAssured.baseURI="https://airportgap.com/api";

     //generate token for authentication purposes

     Response tokenResponse = RestAssured.given()
             .header("Content-Type", "application/x-www-form-urlencoded")
             .body(ConfigReader.readProperty("credentials"))
             .when().post("/tokens").then().statusCode(200).extract().response();


     Map<String,Object> parsedResponse = tokenResponse.as(new TypeRef<Map<String, Object>>() {
     });
    String token= (String) parsedResponse.get("token");


     Response distanceResponse = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
             .header("token", token)
             .body(Payloads.getAirportsPayload("ORD", "IST"))
             .post("https://airportgap.com/api/airports/distance")
             .then().statusCode(200).log().body()
             .extract().response();




 }





















}
