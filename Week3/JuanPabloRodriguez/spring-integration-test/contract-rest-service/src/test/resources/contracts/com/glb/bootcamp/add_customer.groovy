package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should add customer with id=4"

	request {
		url "/customer"
		method POST()
	}

	response {
		status CREATED()
		headers {
			contentType applicationJson()
		}
		body (
			id: 4,
			name: "James",
			surname: "Rodriguez"
		)
	}
}