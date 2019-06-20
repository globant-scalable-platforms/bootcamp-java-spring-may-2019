package com.glb.bootcamp.PUT

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should update a customer by id = 1"

    request {
        method PUT()
        url "/customer/id/1"
        body(
                id:1,
                name:"Mike",
                surname:"Gutierrez"
        )
        headers {
            contentType applicationJson()
        }

    }

    response {
        status OK()
        body(
                id:1,
                name:"Mike",
                surname:"Gutierrez"
        )
        headers {
            contentType applicationJson()
        }

    }
}
