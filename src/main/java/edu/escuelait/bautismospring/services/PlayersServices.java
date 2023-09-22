package edu.escuelait.bautismospring.services;

import edu.escuelait.bautismospring.domain.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServices implements IPlayersServices {

    public List<Player> getPlayersByTeam(String teamName) {

        List<Player> players = null;

        if (teamName.equalsIgnoreCase("argentina")) {

            players = List.of(
                    new Player("messi", 10),
                    new Player("montiel", 12),
                    new Player("maccallister", 7)
            );

        } else if (teamName.equalsIgnoreCase("españa")) {

            players = List.of(
                    new Player("alba", 1),
                    new Player("morata", 2),
                    new Player("xavi", 8)
            );

        } else if (teamName.equalsIgnoreCase("venezuela")) {

            players = List.of(
                    new Player("rondon", 10),
                    new Player("arango", 17),
                    new Player("jose manuel rey", 5)
            );

        }

        return players;

    }
}
