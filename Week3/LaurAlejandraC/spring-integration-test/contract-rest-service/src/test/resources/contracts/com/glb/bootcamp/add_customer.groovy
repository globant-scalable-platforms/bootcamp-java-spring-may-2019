package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should create a Customer with id 4"

    request {
        url "/customer"
        method POST()
        headers{
            contentType applicationJson()
        }
        body(
                id: 4,
                name: "Laura",
                surname: "Chaparro"
        )
    }

    response {
        status CREATED()
        headers{
            contentType applicationJson()
        }
        body(
                id: 4,
                name: "Laura",
                surname: "Chaparro"
        )
    }
}