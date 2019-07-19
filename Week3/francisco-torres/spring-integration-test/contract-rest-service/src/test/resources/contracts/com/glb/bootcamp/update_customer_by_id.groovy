package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should update a customer"

    request {
        method PUT()
        url "/customers/2"
        headers {
            contentType applicationJson()
        }
        body(
                id: 2,
                name: "Pedro",
                surname: "Rodriguez"
        )
    }

    response {
        status OK()
    }
}
