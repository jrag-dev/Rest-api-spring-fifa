package edu.escuelait.bautismospring.domain;


import lombok.Data;
import lombok.NonNull;

@Data
public class Team {

    @NonNull
    private String countryName;

    @NonNull
    private String conf;

    private int rankingFifa;

}