package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should create a new customer with id=4"

	request {
		url "/customer"
		method POST()
        body(
            id: 4,
            name: "Diego",
            surname: "Alvarez"
        )
        headers {
			contentType applicationJson()
		}
	}

	response {
		status OK()
		headers {
			contentType applicationJson()
		}
		body (
            id: 4,
            name: "Diego",
            surname: "Alvarez"
		)
	}
}