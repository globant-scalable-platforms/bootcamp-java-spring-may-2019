package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create a customer"

    request {
        method POST()
        url "/customers"
        headers {
            contentType applicationJson()
        }
        body(
                id: 4,
                name: "Juan",
                surname: "Perez"
        )
    }

    response {
        status CREATED()
    }
}
