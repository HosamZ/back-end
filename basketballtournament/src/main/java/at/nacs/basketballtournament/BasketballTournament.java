package at.nacs.basketballtournament;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
@RequiredArgsConstructor
public class BasketballTournament {

    private final TeamLoader loader;
    private final Tournament tournament;

    public void start() {
        System.out.println("--------------------------------------");
        System.out.println("Welcome to the street basketball tournament! ");
        System.out.println("These are the teams who signed up: ");
        Queue<BasketballTeam> teams = loader.getTeams();
        teams.stream()
                .forEach(e ->
                        System.out.println("TeamLoader: " + e.getName()
                                + " | Players: " + e.getPlayers()));
        System.out.println("-------------------------------------");
        tournament.play(teams);

        // tournament play
    }

}
