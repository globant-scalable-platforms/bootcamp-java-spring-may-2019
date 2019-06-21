package com.glb.bootcamp;

import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.globant.bootcamp:contract-rest-service")
public class ContractRestClientApplicationTest {

	@StubRunnerPort("contract-rest-service")
	private int port;

	@Test
	public void postCustomerFromServiceContract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer(4L,"Juan","Perez");

		// when:
		ResponseEntity entity = restTemplate.exchange(RequestEntity.post(URI.create("http://localhost:" + port + "/customers"))
				.contentType(MediaType.APPLICATION_JSON)
				.body(customer), ResponseEntity.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void getCustomerFromServiceContract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();

		// when:
		ResponseEntity<Customer> entity = restTemplate.exchange(RequestEntity.get(URI.create("http://localhost:" + port + "/customers/1"))
				.build(), Customer.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(1L);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("Mike");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Castro");
	}

	@Test
	public void putCustomerFromServiceContract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer(2L,"Pedro","Rodriguez");

		// when:
		ResponseEntity entity = restTemplate.exchange(RequestEntity.put(URI.create("http://localhost:" + port + "/customers/2"))
				.contentType(MediaType.APPLICATION_JSON)
				.body(customer), ResponseEntity.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void deleteCustomerFromServiceContract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();

		// when:
		ResponseEntity entity = restTemplate.exchange(RequestEntity.delete(URI.create("http://localhost:" + port + "/customers/1"))
				.build(), ResponseEntity.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
	}
}
