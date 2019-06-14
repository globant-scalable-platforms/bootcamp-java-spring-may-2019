package com.glb.bootcamp.POST

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return the added customer by id=4"

    request {
        url "/customer/4"
        method POST()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 4,
                name: "William",
                surname: "Diaz"
        )
    }
}


