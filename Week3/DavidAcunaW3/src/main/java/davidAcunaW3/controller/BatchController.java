package davidAcunaW3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import davidAcunaW3.configuration.BatchFacade;

@RestController
public class BatchController {

	private BatchFacade batchFacade;

	@Autowired
	public BatchController(BatchFacade batchFacade) {
		this.batchFacade = batchFacade;
	}

	@GetMapping(value = "/batch", produces = "text/plain")
	public ResponseEntity<String> executeBatch() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(batchFacade.execute());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
