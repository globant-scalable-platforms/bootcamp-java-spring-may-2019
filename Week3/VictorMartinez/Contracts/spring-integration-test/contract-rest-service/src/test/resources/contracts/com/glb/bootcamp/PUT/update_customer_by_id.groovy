package com.glb.bootcamp.PUT

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should update a customer by id = 3"

    request {
        method PUT()
        url "/customer/id/3"
        body(
                id:3,
                name:"Daniel",
                surname:"Gutierrez"
        )
        headers {
            contentType applicationJson()
        }

    }

    response {
        status OK()
        body(
                id:3,
                name:"Daniel",
                surname:"Gutierrez"
        )
        headers {
            contentType applicationJson()
        }

    }
}
