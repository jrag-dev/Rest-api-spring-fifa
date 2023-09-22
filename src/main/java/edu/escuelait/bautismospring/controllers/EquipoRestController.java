package edu.escuelait.bautismospring.controllers;


import edu.escuelait.bautismospring.domain.Team;
import edu.escuelait.bautismospring.services.IPlayersServices;
import edu.escuelait.bautismospring.services.PlayersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/teams")
public class EquipoRestController {

    //@Autowired
    //private IPlayersServices playersServices;

    private IPlayersServices playersServices;

    public EquipoRestController(IPlayersServices playersServices) {
        this.playersServices = playersServices;
    }


    // Listado de equipos, para simplificar y no usar una base de datos
    ArrayList<Team> teams = new ArrayList<>(
            List.of(
                    new Team("Argentina", "Conmebol"),
                    new Team("Mexico", "Concacat"),
                    new Team("Venezuela", "Conmebol"),
                    new Team("España", "UEFA")
            )
    );

    // Todo: Listar todos los equipos
    @GetMapping
    public List<Team> getTeams() {
        return this.teams;
    }

    // Todo: Listar todos los equipos
    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeamById(@PathVariable String name) {

        for (Team team : this.teams) {
            if (team.getCountryName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(team);
            }
        }

        return ResponseEntity.notFound().build();

    }

    // Todo: Crear un equipo
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team teamRequest) {

        for (Team team1 : this.teams) {
            if (team1.getCountryName().equalsIgnoreCase(teamRequest.getCountryName())) {
                return ResponseEntity.badRequest().build();
            }
        }

        this.teams.add(teamRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{teamRequest.getCountryName}")
                .buildAndExpand(teamRequest.getCountryName())
                .toUri();

        return ResponseEntity.created(location).build();

    }


    // Todo: Actualizar un equipo por su id
    @PutMapping("/{name}")
    public ResponseEntity<Team> updateTeam(@RequestBody Team teamRequest) {

        for (Team team : this.teams) {
            if (team.getCountryName().equalsIgnoreCase(teamRequest.getCountryName())) {
                //team.setCountryName(teamRequest.getCountryName());
                team.setConf(teamRequest.getConf());
                team.setRankingFifa(teamRequest.getRankingFifa());
                return ResponseEntity.ok(team);
            }
        }

        return ResponseEntity.notFound().build();

    }

    // Todo: Eliminar un equipo por su id

    @DeleteMapping("/{name}")
    public ResponseEntity deleteTeamById(@PathVariable String name) {

        for (Team team : this.teams) {
            if (team.getCountryName().equalsIgnoreCase(name)) {
                this.teams.remove(team);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/jugar/{teamA}/{teamB}")
    public String jugar(@PathVariable String teamA, @PathVariable String teamB) {
        Random random = new Random();
        int golesA = random.nextInt(10);
        int golesB = random.nextInt(4);

        return "Team " + teamA + " (" + golesA + ")" + " - Team " + teamB + " (" + golesB + ")";
    }


    @GetMapping("/{teamsName}/players")
    public ResponseEntity<?> listPlayersByTeam(@PathVariable String teamsName) {

        List players = playersServices.getPlayersByTeam(teamsName);

        return ResponseEntity.ok(players);
    }


}
