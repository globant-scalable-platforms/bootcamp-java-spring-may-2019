package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should update customer with id=2"

	request {
		url "/customer/2"
		method PUT()
		headers {
			contentType applicationJson()
		}
		body (
			id: 2,
			name: "Update",
			surname: "Customer"
		)
	}

	response {
		status OK()
		headers {
			contentType applicationJson()
		}
		body (
			id: 2,
			name: "Update",
			surname: "Customer"
		)
	}
}