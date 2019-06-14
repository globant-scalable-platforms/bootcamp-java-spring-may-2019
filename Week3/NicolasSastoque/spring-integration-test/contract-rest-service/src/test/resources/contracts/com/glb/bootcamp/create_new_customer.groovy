package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return a new customer created"

	request {
		url "/customer"
		method POST()

		headers {
			contentType applicationJson()
		}
		body(
				name: "Nicolás",
				surname: "Sastoque"
		)
	}

	response {
		status CREATED()
		headers {
			contentType applicationJson()
		}
		body (
			id: 4,
			name: "Nicolás",
			surname: "Sastoque"
		)
	}
}
