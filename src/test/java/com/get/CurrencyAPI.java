package com.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CurrencyAPI {



  @Test
  public void validateCurrencyOfaCountry(){

   String endPoint="https://openexchangerates.org/api/currencies.json";

      Response response = RestAssured.given().accept("application/json").when().get(endPoint).then().statusCode(200).extract().response();


      //TypeRef help us to convert json to java
      Map<String,String> deserializedResponse = response.as(new TypeRef<Map<String, String>>() {
      });


      String turkeyCurrency = deserializedResponse.get("TRY");
      System.out.println("turkeyCurrency = " + turkeyCurrency);
 String expected = "Turkish Lira";
      Assert.assertEquals(turkeyCurrency,expected,"failed to validate currency from json file");



      for (Map.Entry<String,String> m :deserializedResponse.entrySet()){

         // String key = m.getKey();//prints out all keys in the map
          //System.out.println(key);

          if(m.getKey().equals("USD")){
              System.out.println(m.getKey());
              System.out.println(m.getValue());
          }
      }


  }




  @Test
    public void validateCatFacts(){

     String endPoint = "https://catfact.ninja/facts?page=10" ;

     //make get calland get the response
      Response response = RestAssured.given().accept("application/json").when().get(endPoint).then().statusCode(200).extract().response();

      Map<String, Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
      });


//      System.out.println(parsedResponse);

      List<Map<String,Object>>  data  = (List<Map<String, Object>>) parsedResponse.get("data");
      System.out.println(data);


      for (int i = 0; i < data.size() ; i++) {

          Map<String,Object> map = data.get(i);

          if (map.get("length").equals(42)){
              System.out.println(map.get("fact"));
              break;
          }

      }
  }















}
