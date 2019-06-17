package com.glb.bootcamp;

import com.glb.bootcamp.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractRestClientApplicationTest {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
		.downloadStub("com.globant.bootcamp", "contract-rest-service-boot", "0.0.1-SNAPSHOT", "stubs")
		.withPort(8100)
		.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	@Test
	public void get_customer_from_service_contract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		ResponseEntity<Customer> entity = 
				restTemplate.getForEntity("http://localhost:8100/customer/1", Customer.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(1l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("Mike");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Castro");
		
	}
	
	@Test
	public void create_customer_from_service_contract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		Customer body = new Customer(4L, "David", "Acuna");
		
		ResponseEntity<Customer> entity = 
				restTemplate.postForEntity("http://localhost:8100/customer", body, Customer.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(201);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(4l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("David");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Acuna");
		
	}
	
}
