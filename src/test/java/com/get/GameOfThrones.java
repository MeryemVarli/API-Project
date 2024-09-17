package com.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GameOfThrones {





@Test
    public void findAryaStark(){

    RestAssured.baseURI="https://thronesapi.com";
    RestAssured.basePath="api/v2/Characters/";

    Response response = RestAssured.given().accept(ContentType.JSON).when().get().then().statusCode(200).extract().response();

    List<Map<String,Object>> deserializedResponse = response.as(new TypeRef<List<Map<String, Object>>>() {
    });


    for (int i = 0; i < deserializedResponse.size(); i++) {

        Map<String, Object> map = deserializedResponse.get(i);

        if (map.get("id").equals(3)){
            System.out.println(map.get("fullName"));
            System.out.println(map.get("family"));
            break;
        }

    }

}











}
