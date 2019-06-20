package com.glb.bootcamp.GET

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer by id=3"

    request {
        url "/customer/id/3"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 3,
                name: "Daniel",
                surname: "Gutierrez"
        )
    }
}
