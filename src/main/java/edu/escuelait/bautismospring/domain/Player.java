package edu.escuelait.bautismospring.domain;


import lombok.Data;
import lombok.NonNull;

@Data
public class Player {

    @NonNull
    private String name;

    @NonNull
    private Integer number;
    private int goals;

}
