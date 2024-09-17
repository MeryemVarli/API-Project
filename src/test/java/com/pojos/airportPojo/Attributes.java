package com.pojos.airportPojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {

    private long kilometers;
    private long miles;
    private long nautical_miles;

    private ToAirport to_airport;
    private FromAirport from_airport;

}
