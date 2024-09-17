package com.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class GetAirport {




@Test
public void getAirportDistance(){


    Response response = RestAssured.given().accept(ContentType.JSON).when().get("https://airportgap.com/api/airports").then().statusCode(200).extract().response();

   // Map<String,Object> parsedResponse

}











}
