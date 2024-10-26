package com.ymd.businessHouseGame;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ymd.businessHouseGame.entity.Board;
import com.ymd.businessHouseGame.entity.Dice;
import com.ymd.businessHouseGame.entity.Player;

@SpringBootApplication
public class BusinessHouseGameApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BusinessHouseGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Player> players = Arrays.asList(new Player("Ram"),
                new Player("Krishna"), new Player("Hari"));
        
        play(players,
                "E,E,J,H,E,T,J,T,E,E,H,J,T,H,E,E,J,H,E,T,J,T,E,E,"
                        + "H,J,T,H,J,E,E,J,H,E,T,J,T,E,E,H,J,T,E,H,E",
                "4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,"
                        + "3,5,6,7,8,5,11,10,12");
		
	}
	
	public void play(List<Player> players, String boardCoordinates, String diceOutputs) {

        Board board = new Board(boardCoordinates);
        Dice dice = new Dice(diceOutputs);

        for (int set = 0; set < 10; set++) {
            out.println("Current set : " + (set + 1));
            players.forEach(player -> {
                Integer numberOfstepsToMove = dice.giveDiceOutput();
                player.move(numberOfstepsToMove, board.getGrid().size());
                board.handlePlayerMove(player);
                out.println(player.getName() + " is at position "
                        + player.getCurrPositionOnBoard()
                        + " and current balance is " + player.getCurrentMoney());
            });
        }
        out.println("-----------------------------The Final Results Are-----------------------");
        printGameEndResults(players);
    }

    private void printGameEndResults(List<Player> players) {
        Comparator<Player> comparator = Comparator.comparing(Player::getCurrentMoney);
        players.stream().sorted(comparator.reversed()).forEach(player -> out.println(player.getName() + " has total worth of " + player.getCurrentMoney()));
    }

}
