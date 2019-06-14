package com.glb.bootcamp;

import com.glb.bootcamp.model.Customer;
import com.glb.bootcamp.model.CustomerRequest;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.globant.bootcamp:contract-rest-service") 
public class ContractRestClientApplicationTest {
	
	@StubRunnerPort("contract-rest-service")
	private int port;
	
	@Test
	public void find_customer_by_id_from_service_contract() {
		Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "1");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:"+port+"/customers/{id}", Customer.class, params);

		// then:
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(1l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("Mike");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Castro");
		
	}	
	
	@Test 
	public void create_customer_from_service_contract() { 
		//given:
		RestTemplate restTemplate = new RestTemplate();
	  
		//when
		CustomerRequest bodyRequest = new CustomerRequest("Santiago", "Medina");
		ResponseEntity<Customer> entity = restTemplate.postForEntity("http://localhost:"+port+"/customers", bodyRequest, Customer.class);
	  
		//then: 
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody().getId()).isEqualTo(4l);
		BDDAssertions.then(entity.getBody().getName()).isEqualTo("Santiago");
		BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Medina"); 
	}
	
	@Test
	public void delete_customer_from_service_contract() {
		Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "3");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:"+port+"/customers/{id}", params);
	}
	
	@Test
	public void update_customer_from_service_contract() {
		Map < String, String > params = new HashMap < String, String > ();
        params.put("id", "2");
        CustomerRequest customerRequest = new CustomerRequest("Globant","Bootcamp");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:"+port+"/customers/{id}", customerRequest, params);
	}
	
		
	 
}
