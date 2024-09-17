package com.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class StarWars {




@Test
    public void findPeopleOnShow(){

    String endpoint ="https://swapi.dev/api/people/1";

    // instead using "application/json" , you can just select 'ContentType.JSON'
    Response response = RestAssured.given().accept(ContentType.JSON).when().get(endpoint).then().statusCode(200).extract().response();

    //using typeRef to convert respons(json file)  to java
    Map<String,Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
    });


    String actualName = (String) parsedResponse.get("name");
    String expectedName ="Luke Skywalker";

    Assert.assertEquals(actualName,expectedName,"failed to validate name field");

    String actualColor = (String) parsedResponse.get("eye_color");  //opt+enter also shortcut to cast
    String expectedColor ="blue";

    Assert.assertTrue(actualColor.equals(expectedColor));


}








}
