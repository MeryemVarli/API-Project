package com.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.airportPojo.DistanceCalculator;
import com.pojos.petPojo.Category;
import com.pojos.petPojo.PetPojo;
import com.pojos.petPojo.Tags;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetSerialization {


    @Test
    public void writeIntoJsonPet() throws IOException {

        PetPojo petPojo=new PetPojo();
        petPojo.setId(333);
        petPojo.setName("kurt");
        petPojo.setStatus("homepet");

        // Create a Category object
        Category category = new Category();
        category.setName("Lilia");  // Set the category name
        category.setId(1);          // Set the category ID

       // Setting the Category Object in the PetPojo Object
        petPojo.setCategory(category);

        List<Tags> dogTags = new ArrayList<>();
        Tags tags = new Tags();
        tags.setName("Bowie");
        tags.setId(2);

        dogTags.add(tags);
        petPojo.setTags(dogTags);

        List<String> photoUrls =new ArrayList<>();
        photoUrls.add("some pic");
        photoUrls.add("another pic");
        photoUrls.add("a image");

        petPojo.setPhotoUrls(photoUrls);

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/petStore2/pet2.json");
        objectMapper.writeValue(file,petPojo);

RestAssured.baseURI="https://petstore.swagger.io";
RestAssured.basePath="v2/pet/";

    Response response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(file).when().post().then().statusCode(200).extract().response();




    }

    @Test
    public  void writeIntoJsonAirport() throws IOException {

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        distanceCalculator.setFrom("ORD");
        distanceCalculator.setTo("IST");

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/airport/distance.json");

        objectMapper.writeValue(file,distanceCalculator);

        RestAssured.baseURI="";
        RestAssured.basePath="";
        RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).body(file).when().post().then().statusCode(200).extract().response();





    }



}
