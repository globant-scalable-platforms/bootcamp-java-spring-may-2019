package davidAcunaW3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import davidAcunaW3.configuration.Message;

@RestController
public class ProfileEndpoint {

	@Autowired
	private Message message;

	@GetMapping(value = "/info", produces = "text/plain")
	public ResponseEntity<String> getMessage() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(message.setup());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
