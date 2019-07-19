package davidAcuna.domain;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {
    
	private String status;
	private List<Integer> playerOneValues = new ArrayList<>();
	private List<Integer> playerTwoValues = new ArrayList<>();
	
	public GameStatus(String status, List<Integer> playerOneValues, List<Integer> playerTwoValues) {
		super();
		this.status = status;
		this.playerOneValues = playerOneValues;
		this.playerTwoValues = playerTwoValues;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Integer> getPlayerOneValues() {
		return playerOneValues;
	}

	public void setPlayerOneValues(List<Integer> playerOneValues) {
		this.playerOneValues = playerOneValues;
	}

	public List<Integer> getPlayerTwoValues() {
		return playerTwoValues;
	}

	public void setPlayerTwoValues(List<Integer> playerTwoValues) {
		this.playerTwoValues = playerTwoValues;
	}		
	
}
