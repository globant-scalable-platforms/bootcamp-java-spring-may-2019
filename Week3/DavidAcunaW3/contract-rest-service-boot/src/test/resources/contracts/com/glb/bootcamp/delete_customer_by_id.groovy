package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should delete customer with id=3"

	request {
		url "/customer/3"
		method DELETE()
	}

	response {
		status OK()
	}
}