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

@Api(value="JoinPointVoidController", description = "Test a joinPoint with void method")
@RestController
public class JoinPointVoidController {

	private BatchFacade batchFacade;

	@Autowired
	public JoinPointVoidController(BatchFacade batchFacade) {
		this.batchFacade = batchFacade;
	}

	@ApiOperation(value="Test a joinPoint with void method", tags="voidTest")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Success|OK"),
		@ApiResponse(code = 500, message = "Error|INTERNAL_SERVER_ERROR")
	})
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
