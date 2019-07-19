package davidAcuna.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Player {
    private List<Integer> results = new ArrayList<>();
    private Integer wins;
    private Integer attempt;
        
	public Player() {		
		wins = 0;
		attempt = 0;
	}

	public List<Integer> getResults() {
		return results;
	}

	public void setResults(List<Integer> results) {
		this.results = results;
	}	

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getAttempt() {
		return attempt;
	}

	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}
	
	
	
}
