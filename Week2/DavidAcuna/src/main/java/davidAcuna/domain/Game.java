package davidAcuna.domain;

import org.springframework.stereotype.Component;

@Component
public class Game {
    
	private Integer attempts;
	
	public Game() {
		this.attempts=0;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}
	
		
}
