package com.glb.bootcamp.POST

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should add a new customer by id, id = 4"

    request {
        url "/customer/id/4"
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
