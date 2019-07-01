package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return new customer with id=4"

	request {
		url "/customers"
		method POST()
		headers {
			contentType applicationJson()
		}
		body (
			name: "Santiago",
			surname: "Medina"
		)
	}

	response {
		status OK()
		headers {
			contentType applicationJson()
		}
		body (
			id: 4,
			name: "Santiago",
			surname: "Medina"
		)
	}
}