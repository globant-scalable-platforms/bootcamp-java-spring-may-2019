package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'DELETE'
        url '/customers/1'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 204
        headers {
            header 'Content-Type': 'application/json'
        }
        body(
                id: 1,
                name: "Mike",
                surname: "Castro"
        )
    }
}
