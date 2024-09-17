package com.post;

import com.pojos.airportPojo.Attributes;
import com.pojos.airportPojo.DataPojo;
import com.pojos.airportPojo.DistancePojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetDistanceAirports {



    
    @Test
    public void getDistance(){

        RestAssured.baseURI="https://airportgap.com";
        RestAssured.basePath="api/airports/distance";

        Response response = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"from\": \"ORD\",\n" +
                        "    \"to\": \"IST\"\n" +
                        "}")
                .when().post().then().log().body()
                .statusCode(200).extract().response();

       // System.out.println(response.prettyPrint());


//        DistancePojo parsedResponse = response.as(DistancePojo.class);
//        System.out.println(parsedResponse.getData().getId());
//        System.out.println(parsedResponse.getData().getType());
//
//        System.out.println(parsedResponse.getData().getAttributes().getKilometers());
//        System.out.println(parsedResponse.getData().getAttributes().getTo_airport().getCity());

        //ot you do:

        DataPojo dataPojo = response.as(DataPojo.class);
        System.out.println(dataPojo.getId());

        Attributes attributes= response.as(Attributes.class);
        System.out.println(attributes.getNautical_miles());


    }
}
