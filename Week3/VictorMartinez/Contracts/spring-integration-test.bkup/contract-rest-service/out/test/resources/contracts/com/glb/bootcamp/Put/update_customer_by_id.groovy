package com.glb.bootcamp.Put

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return the updated customer by id=5"

    request {
        url "/customer/5"
        method PUT()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 5,
                name: "Luis",
                surname: "Jaimes"
        )
    }
}


