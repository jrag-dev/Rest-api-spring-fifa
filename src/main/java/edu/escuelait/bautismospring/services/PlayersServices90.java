package edu.escuelait.bautismospring.services;

import edu.escuelait.bautismospring.domain.Player;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PlayersServices90 implements IPlayersServices {

    public List<Player> getPlayersByTeam(String teamName) {

        List<Player> players = null;

        if (teamName.equalsIgnoreCase("argentina")) {

            players = List.of(
                    new Player("maradona", 10),
                    new Player("rugueri", 12),
                    new Player("batistuta", 7)
            );

        } else if (teamName.equalsIgnoreCase("españa")) {

            players = List.of(
                    new Player("butragueño", 1),
                    new Player("salinas", 2),
                    new Player("otro", 8)
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
