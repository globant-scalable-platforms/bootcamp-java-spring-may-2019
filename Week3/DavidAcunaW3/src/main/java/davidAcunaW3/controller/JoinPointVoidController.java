package davidAcunaW3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import davidAcunaW3.configuration.BatchFacade;

@RestController
public class JoinPointVoidController {

	private BatchFacade batchFacade;

	@Autowired
	public JoinPointVoidController(BatchFacade batchFacade) {
		this.batchFacade = batchFacade;
	}

	@GetMapping(value = "/voidTest", produces = "text/plain")
	public ResponseEntity<String> executeBatch() {
		try {
			batchFacade.voidExecute();
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
