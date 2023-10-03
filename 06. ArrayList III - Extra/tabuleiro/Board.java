package tabuleiro;

import java.util.ArrayList;

public class Board {
	private ArrayList<Integer> trapList;
	private ArrayList<Player> players;
	private boolean running;
	private int boardSize;
	private int player; // Armazena o jogador da vez

	public Board(int nPlayers, int boardSize) {
		this.players = new ArrayList<>();
		this.trapList = new ArrayList<>();
		this.boardSize = boardSize + 1;
		this.running = true;
		this.player = 0;
		for (int i = 0; i < nPlayers; i++) {
			players.add(new Player(i+1));
		}
	}

	public void addTrap(int pos) {
		trapList.add(pos);
	}

	public boolean inTrap(int index) {
		for (int pos : trapList) {
			if (players.get(index).getPos() == pos) {
				return true;
			}
		}
		return false;
	}

	public int rollDice(int value) {
	    if(running){
    	    var turn = players.get(player);
    		if (turn.isFree()) {
    			turn.setPos(turn.getPos() + value);
    			if (turn.getPos() >= boardSize-1) {
    				this.running = false;
    				turn.setPos(boardSize - 1);
    				
    				return player;
    			}
    		    if(running) {
    		    	System.out.println("player" + turn.getLabel() + " andou para " + turn.getPos());
    		    }
    			if (inTrap(player)) {
    				System.out.println("player" + turn.getLabel() + " caiu em uma armadilha");
    				turn.setFree(false);
    			} 
    			
    		} else if (value % 2 == 0) {
    			System.out.println("player" + turn.getLabel() + " se libertou");
    			turn.setFree(true);
    		} else {
    			System.out.println("player" + turn.getLabel() + " continua preso");
    		}
	    } else{
	        System.out.println("game is over");
	    }
		
		player = (++player) % players.size();
	    return -1;
	    
	}
	
	@ Override
	public String toString() {
		String ss = "";
		
		for(int i = 0; i < players.size(); i++) {
			ss += "player" + (i+1) + ": ";
			for(int j = 0; j < boardSize; j++) {
				if(players.get(i).getPos() == j) {
					ss += i+1;
				} else {
					ss += ".";
				}
			}
			ss += "\n";
		}
		
		ss += "traps__: ";
		boolean isX = false;
		for(int j = 0; j < boardSize; j++) {
			for(int i = 0; i < trapList.size(); i++) {
				if(trapList.get(i) == j) {
					ss += "x";
					isX = true;
				}
		    }
		    if(!isX)
                ss += ".";
            isX = false;
		}
		
		return ss;
	}
}