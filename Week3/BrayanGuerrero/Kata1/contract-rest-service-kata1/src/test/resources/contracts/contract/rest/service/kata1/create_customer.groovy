package contract.rest.service.kata1

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should create a customer"

	request {
		url "/createCustomer"
		method POST()
		headers {
	      contentType applicationJson()
	    }
		body(
			id: 4,
			name: "Bryan",
			surname: "Guerrero"
		)
	}

	response {
		status CREATED()
	}
}