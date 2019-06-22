package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/customers/1'
        headers {
            contentType(applicationJson())
        }
        body(
                id: 1,
                name: "David",
                surname: "Gilmour"
        )
    }
    response {
        status 201
        headers {
            header 'Content-Type': 'application/json'
        }
        body(
                id: 1,
                name: "David",
                surname: "Gilmour"
        )
    }
}
