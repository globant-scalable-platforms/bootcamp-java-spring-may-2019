package com.glb.bootcamp.GET

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer by name = Mauro"

    request {
        url "/customer/id/Mike"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 1,
                name: "Mike",
                surname: "Castro"
        )
    }
}
