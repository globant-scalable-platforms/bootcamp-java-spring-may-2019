package com.glb.bootcamp.GET;

import com.glb.bootcamp.model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = {"com.globant.bootcamp:contract-rest-service:+:stubs"})
public class ContractRestClientGETuserByNameTest {

    @StubRunnerPort("contract-rest-service")
    private int port;


    @Test
    public void get_customer_from_service_contract() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:"+port+"/customer/name/Mike", Customer.class);

        // then:
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody().getId()).isEqualTo(1l);
        BDDAssertions.then(entity.getBody().getName()).isEqualTo("Mike");
        BDDAssertions.then(entity.getBody().getSurname()).isEqualTo("Castro");

    }
}
