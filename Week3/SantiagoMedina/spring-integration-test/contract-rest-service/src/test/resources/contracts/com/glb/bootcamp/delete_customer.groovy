package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should delete a customer"

	request {
		url "/customers/3"
		method DELETE()
	}

	response {
		status OK()
	}
}