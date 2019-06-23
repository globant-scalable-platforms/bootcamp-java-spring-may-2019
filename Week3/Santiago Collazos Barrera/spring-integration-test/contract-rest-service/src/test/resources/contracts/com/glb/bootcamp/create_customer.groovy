package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return the new customer created with the body decribe below"

	request {
		url "/customer/"
		method POST()
		body(
                id:10,
        		name: "Santiago",
        		surname: "Collazos"
    	)
    	headers {
      		contentType applicationJson()
    	}
	}

	response {
		status CREATED()
		headers {
			contentType applicationJson()
		}
		body (
			id: 10,
			name: "Santiago",
			surname: "Collazos"
		)
	}
}