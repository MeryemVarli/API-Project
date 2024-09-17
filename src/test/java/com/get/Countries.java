package com.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Countries {



 @Test
 public void findCountry(){

     Response response = RestAssured.given().accept("application/json").when().get("https://restcountries.com/v3.1/all").then().statusCode(200).extract().response();

     List<Map<String,Object>> deserializedResponse = response.as(new TypeRef<List<Map<String, Object>>>() {
     });



for (Map<String,Object> m: deserializedResponse){

Map<String,Object> map = (Map<String, Object>) m.get("name");

if (map.get("common").equals("Turkey")){

    System.out.println(m.get("capital"));
}
}



 }








}
