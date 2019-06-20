package com.glb.bootcamp.GET;

import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractRestClientGetuserID3 {

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
        ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:8100/customer/id/3", Customer.class);

        // then:
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody().getId()).isEqualTo(3l);
        BDDAssertions.then(entity.getBody().getName()).isEqualTo("Daniel");
        BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Gutierrez");

    }
}
