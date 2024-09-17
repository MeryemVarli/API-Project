package com.payloads;

public class Payloads {



  public static String getPetPayload(int id,String name,String status){

     return "{\"id\":"+id+",\n" +
             "  \"name\":\""+name+"\",\n" +
             "  \"status\":\""+status+"\",\n" +
             "  \"category\":\n" +
             "  {\"id\":1200,\n" +
             "    \"name\":\"Lilia\"\n" +
             "  },\n" +
             "  \"photoUrls\":[\n" +
             "    \"some dog images\",\n" +
             "    \"another image\",\n" +
             "    \"one images\"\n" +
             "  ],\n" +
             "  \"tags\":[\n" +
             "    {\n" +
             "      \"id\":555,\n" +
             "      \"name\":\"Roxy\"\n" +
             "    }\n" +
             "  ]\n" +
             "}";




  }

    public static String getAirportsPayload(String airport1,String airport2){

        return "{\n" +
                "    \"from\": \""+airport1+"\",\n" +
                "    \"to\": \""+airport2+"\"\n" +
                "}";

    }













}
