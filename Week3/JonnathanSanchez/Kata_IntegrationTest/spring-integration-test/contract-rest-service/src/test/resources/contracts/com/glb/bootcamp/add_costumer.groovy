package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should add a new customer"

	request {
		url "/customers"
		method POST()
		headers {
			contentType applicationJson()
		}
		body(
			id: 4,
			name: "Jonnathan",
			surname: "Sanchez"
		)
	}

	response {
		status CREATED()
		headers {
			contentType applicationJson()
		}
		body(
			id: 4,
			name: "Jonnathan",
			surname: "Sanchez"
		)
	}
}