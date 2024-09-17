package com.get;

import com.pojos.petPojo.PetPojo;
import com.pojos.petPojo.Tags;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class PetStore {



@Test
public void getDog(){

    RestAssured.baseURI="https://petstore.swagger.io/v2";

    Response response = RestAssured.given().accept("application/json").when().get("/pet/150").then().statusCode(200).extract().response();


    PetPojo parsedResponse = response.as(PetPojo.class);

    int id = parsedResponse.getId();
    int id1 = parsedResponse.getCategory().getId();

    List<String> photoUrls = parsedResponse.getPhotoUrls();
    System.out.println(photoUrls);


    List<Tags> tags = parsedResponse.getTags();
    System.out.println(tags.get(0).getId());
    System.out.println(tags.get(0).getName());


}













}
