package com.glb.bootcamp.GET



import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return empty customer by id=2"

    request {
        url "/customer/id/2"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 0L,
                name: "-",
                surname: "-"
        )
    }
}

