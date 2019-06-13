package com.glb.bootcamp;

import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractRestClientApplicationTest {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
		.downloadStub("com.globant.bootcamp", "contract-rest-service", "0.0.1-SNAPSHOT", "stubs")
		.withPort(8100)
		.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	@Test
	public void get_customer_from_service_contract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:8100/customer/1", Customer.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(1l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("Mike");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Castro");
		
	}

	@Test
	public void addCustomerFromServiceContract(){
		RestTemplate restTemplate = new RestTemplate();

		Customer customer = new Customer(4L, "Laura", "Chaparro");

		ResponseEntity<Customer> entity = restTemplate.postForEntity("http://localhost:8100/customer", customer, Customer.class);

		Assert.assertEquals(entity.getStatusCode(), HttpStatus.CREATED);
		Assert.assertEquals(4L, (long) entity.getBody().getId());
		Assert.assertEquals("Laura", entity.getBody().getName());
		Assert.assertEquals("Chaparro", entity.getBody().getSurname());
	}
}
