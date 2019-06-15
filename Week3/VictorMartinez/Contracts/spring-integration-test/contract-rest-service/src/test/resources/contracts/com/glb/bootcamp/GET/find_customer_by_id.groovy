package com.glb.bootcamp.GET

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return customer by id=1"

	request {
		url "/customer/id/1"
		method GET()
	}

	response {
		status OK()
		headers {
			contentType applicationJson()
		}
		body (
				id: 1,
				name: "Mike",
				surname: "Castro"
		)
	}
}