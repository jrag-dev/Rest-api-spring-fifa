package edu.escuelait.bautismospring.services;

import edu.escuelait.bautismospring.domain.Player;

import java.util.List;

public interface IPlayersServices {

    public List<Player> getPlayersByTeam(String teamName);

}
