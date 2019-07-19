package davidAcunaW3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import davidAcunaW3.configuration.BatchFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="BatchController", description="REST APIs related to aspect tests")
@RestController
public class BatchController {

	private BatchFacade batchFacade;

	@Autowired
	public BatchController(BatchFacade batchFacade) {
		this.batchFacade = batchFacade;
	}

	@ApiOperation(value="Tests aspects", tags="batch")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success|OK"),
		@ApiResponse(code = 500, message = "Error|INTERNAL_SERVER_ERROR")
	})
	@GetMapping(value = "/batch", produces = "text/plain")
	public ResponseEntity<String> executeBatch() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(batchFacade.execute());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
