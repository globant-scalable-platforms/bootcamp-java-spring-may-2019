package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should create customer with id=4"

	request {
		url "/customer"
		method POST()
		headers {
			contentType applicationJson()
		}
		body (
			id: 4,
			name: "David",
			surname: "Acuna"
		)
	}

	response {
		status CREATED()
		headers {
			contentType applicationJson()
		}
		body (
			id: 4,
			name: "David",
			surname: "Acuna"
		)
	}
}