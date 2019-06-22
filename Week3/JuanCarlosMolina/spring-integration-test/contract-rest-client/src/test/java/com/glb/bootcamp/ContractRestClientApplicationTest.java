package com.glb.bootcamp;

import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestClientApplicationTest {

	@Autowired
	private MockMvc mockMvc;


	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
		.downloadStub("com.globant.bootcamp", "contract-rest-service", "0.0.1-SNAPSHOT", "stubs")
		.withPort(8100)
		.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	@Test
	public void getCustomerFromServiceContract() {
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
	public void save_customer() throws Exception{

		String url = "http://localhost:8100/customers/";

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Customer> request = new HttpEntity<>(new Customer(0L,"James","Hetfield"));

		int statusCodeValue = restTemplate.postForEntity(url, request, String.class).getStatusCodeValue();

		BDDAssertions.then(statusCodeValue == HttpStatus.CREATED.value());

	}

	@Test
	public void update_customer(){

		String url = "http://localhost:8100/customers/1";

		RestTemplate restTemplate = new RestTemplate();

		Customer customer = new Customer(1L,"David","Gilmour");

		URI uri = null;
		try{
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		RequestEntity<Customer> requestEntity = RequestEntity
					.put(uri)
					.accept(MediaType.APPLICATION_JSON)
					.body(customer);



		int statusCodeValue = restTemplate.exchange(requestEntity, Customer.class).getStatusCodeValue();

		BDDAssertions.then(statusCodeValue == HttpStatus.CREATED.value());

	}

	@Test
	public void delete_customer(){

		String url = "http://localhost:8100/customers/1";

		RestTemplate restTemplate = new RestTemplate();

		URI uri = null;

		try{
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Type","application/json");

		RequestEntity  requestEntity = new RequestEntity(null, headers,HttpMethod.DELETE, uri);

		int statusCodeValue = restTemplate.exchange(requestEntity, Customer.class).getStatusCodeValue();

		BDDAssertions.then(statusCodeValue == HttpStatus.NO_CONTENT.value());

	}

}
