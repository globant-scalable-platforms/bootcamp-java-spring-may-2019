package davidAcuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import davidAcuna.domain.Game;
import davidAcuna.domain.GameStatus;
import davidAcuna.domain.Player;
import davidAcuna.impl.GameImp;

@RestController
@RequestMapping(value = "/game")
public class GameController {
        
    @Autowired
	private GameImp gameImp;
    
	@Autowired
    @Qualifier(value="playerScope")
    private Player playerOne;
	
	@Autowired
    @Qualifier(value="playerScope")
    private Player playerTwo;
    
    @Autowired
    @Qualifier(value="gameSingleton")
    private Game game;
    
    /**
	 * Show game information so far
	 * 
	 * @return game info
	 */
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<GameStatus> getGameResult() {        
    	try {
    		GameStatus info;
    		if(game.getAttempts() %6 == 0 && game.getAttempts() >0) {
    			info= gameImp.determineWinner(playerOne.getResults(), playerTwo.getResults());
    		}else {
    			info = gameImp.getGameStatus(playerOne, playerTwo, game.getAttempts(), true);
    		}
    		return ResponseEntity.status(HttpStatus.OK)
					.body(info);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
    } 
    
    /**
	 * Simulates the attempt of player number one
	 * 
	 * @return game info
	 */
    @GetMapping(value = "/player-one", produces = "application/json")
    public ResponseEntity<GameStatus> playNumberOne() {        
    	try {
    		GameStatus info;
    		if(game.getAttempts() %6 == 0 && game.getAttempts() >0) {
    			info= gameImp.determineWinner(playerOne.getResults(), playerTwo.getResults());
    		}else {
    			Boolean result = gameImp.play(playerOne, playerTwo, game);
    			info = gameImp.getGameStatus(playerOne, playerTwo, game.getAttempts(), result);
    		}
			return ResponseEntity.status(HttpStatus.OK)
					.body(info);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
    }
    
    /**
   	 * Simulates the attempt of player number two
   	 * 
   	 * @return game info
   	 */
    @GetMapping(value = "/player-two", produces = "application/json")
    public ResponseEntity<GameStatus> playNumberTwo() {        
    	try {
    		GameStatus info;
    		if(game.getAttempts() %6 == 0 && game.getAttempts() >0) {
    			info= gameImp.determineWinner(playerOne.getResults(), playerTwo.getResults());
    		}else {
    			Boolean result = gameImp.play(playerTwo, playerOne, game);
    			info = gameImp.getGameStatus(playerOne, playerTwo, game.getAttempts(), result);
    		}
			return ResponseEntity.status(HttpStatus.OK)
					.body(info);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
    }
    
   
}
