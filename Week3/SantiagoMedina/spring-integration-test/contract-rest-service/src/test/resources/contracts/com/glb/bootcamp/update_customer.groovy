package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should update a customer"

	request {
		url "/customers/2"
		method PUT()
		headers {
			contentType applicationJson()
		}
		body (
			name: "Globant",
			surname: "Bootcamp"
		)
	}

	response {
		status OK()
	}
}