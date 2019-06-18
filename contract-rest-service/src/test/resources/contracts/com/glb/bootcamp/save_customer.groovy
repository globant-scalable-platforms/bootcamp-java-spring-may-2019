package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/customers/'
        headers {
            contentType(applicationJson())
        }
        body(
                id: 0,
                name: "James",
                surname: "Hetfield"
        )
    }
    response {
        status 201
        headers {
            header 'Content-Type': 'application/json'
        }
    }
}