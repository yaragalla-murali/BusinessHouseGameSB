package com.ymd.businessHouseGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ymd.businessHouseGame.entity.Board;
import com.ymd.businessHouseGame.entity.Hotel;
import com.ymd.businessHouseGame.entity.Player;

@SpringBootTest
public class BoardTest {
	
	Board gameBoard=new Board("E,J,T,H");
	
	@Test
	public void whenJailCell() {
		int totalCellsInBoard=gameBoard.getGrid().size();
		int cellNumberInBoard=1;
		Player player=new Player("hari");
		player.move(cellNumberInBoard, totalCellsInBoard);
		gameBoard.handlePlayerMove(player);
		assertEquals(850,player.getCurrentMoney().intValue());
	}
	
	@Test
	public void whenTreasureCell() {
		int totalCellsInBoard=gameBoard.getGrid().size();
		int cellNumberInBoard=2;
		Player player=new Player("hari");
		player.move(cellNumberInBoard, totalCellsInBoard);
		gameBoard.handlePlayerMove(player);
		assertEquals(1200,player.getCurrentMoney().intValue());
	}
	
	@Test
	public void whenHotelOwnership() {
		int totalCellsInBoard=gameBoard.getGrid().size();
		int cellNumberInBoard=3;
		Player player=new Player("hari");
		player.move(cellNumberInBoard, totalCellsInBoard);
		gameBoard.handlePlayerMove(player);
		assertEquals(800,player.getCurrentMoney().intValue());
		Hotel hotelCell=(Hotel)gameBoard.getGrid().get(cellNumberInBoard);
		assertEquals("hari", hotelCell.getOwner());
		
	}
	
	@Test
	public void whenHotelRenting() {
		int totalCellsInBoard=gameBoard.getGrid().size();
		int cellNumberInBoard=3;
		Player player=new Player("hari");
		Hotel hotelCell=(Hotel)gameBoard.getGrid().get(cellNumberInBoard);
		hotelCell.setOwner("hari");
		player.move(cellNumberInBoard, totalCellsInBoard);
		gameBoard.handlePlayerMove(player);
		assertEquals(950,player.getCurrentMoney().intValue());	
		
	}

}
