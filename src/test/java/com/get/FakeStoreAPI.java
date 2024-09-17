package com.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;

public class FakeStoreAPI {


 @Test
 public void validateField(){

      //String endPoint ="https://fakestoreapi.com/products/1";

     //instead we do :

     RestAssured.baseURI="https://fakestoreapi.com";
     RestAssured.basePath="products/1";

     //when you use basePath and base Url you do not have to put endpoint in get
     Response response = RestAssured.given().accept("application/json").when().get().then().statusCode(522).extract().response();

     //deserialization is converting from api to java (or parsing)
     Map<String,Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
     });

        Integer actualID = (Integer) deserializedResponse.get("id");
        Integer expectedID = 12;

     Assert.assertEquals(actualID,expectedID);


 }

 @Test
    public void validateField2(){

//     String endPoint="https://fakestoreapi.com/products";
     RestAssured.baseURI ="https://fakestoreapi.com";
//     RestAssured.basePath="products";

     //if you do not use basePath when u use baseUrl then you need to put that path in get call
     Response response = RestAssured.given().accept("application/json").when().get("/products").then().statusCode(200).extract().response();


     List<Map<String ,Object>> parsedResponse = response.as(new TypeRef<List<Map<String, Object>>>() {
     });

     double totalPrice = 0;
     for (int i=0;i< parsedResponse.size();i++){

         Map<String,Object> map = parsedResponse.get(i);

         //parsing
         Double price =Double.parseDouble(map.get("price").toString());
         totalPrice+=price;


     }
     Assert.assertTrue(totalPrice>2000);
     System.out.println(totalPrice);
 }





















}
