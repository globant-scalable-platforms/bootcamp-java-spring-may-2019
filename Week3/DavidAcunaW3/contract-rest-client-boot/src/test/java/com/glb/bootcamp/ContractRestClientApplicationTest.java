package com.glb.bootcamp;

import com.glb.bootcamp.model.Customer;

import java.net.URI;
import java.net.URISyntaxException;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.globant.bootcamp:contract-rest-service-boot")
public class ContractRestClientApplicationTest {
	
	@StubRunnerPort("contract-rest-service-boot")
	private int port;

//	@Rule
//	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
//		.downloadStub("com.globant.bootcamp", "contract-rest-service-boot", "0.0.1-SNAPSHOT", "stubs")
//		.withPort(8100)
//		.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	@Test
	public void get_customer_from_service_contract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		ResponseEntity<Customer> entity = 
				restTemplate.getForEntity("http://localhost:"+port+"/customer/1", Customer.class);

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
				restTemplate.postForEntity("http://localhost:"+port+"/customer", body, Customer.class);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(201);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(4l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("David");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Acuna");
		
	}
	
	@Test
	public void delete_customer_from_service_contract() throws URISyntaxException {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		Long id = 3L;
		String url = "http://localhost:"+port+"/customer/"+id;		
		HttpHeaders headers = new HttpHeaders();

		RequestEntity<?>  requestEntity = 
				new RequestEntity<>(null, headers,HttpMethod.DELETE, new URI(url));

		ResponseEntity<?> entity = 
				restTemplate.exchange(requestEntity, Customer.class);
		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);		
	}
	
	@Test
	public void update_customer_from_service_contract() throws URISyntaxException {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		Long id = 2L;
		String url = "http://localhost:"+port+"/customer/"+id;	
		Customer body = new Customer(2L, "Update", "Customer");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		
		RequestEntity<?>  requestEntity = 
				new RequestEntity<>(body, headers,HttpMethod.PUT, new URI(url));

		ResponseEntity<Customer> entity = 
				restTemplate.exchange(requestEntity, Customer.class);
		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(2l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("Update");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Customer");
	}
	
}
