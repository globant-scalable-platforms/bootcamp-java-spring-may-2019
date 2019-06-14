package com.glb.bootcamp.GET


import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer by id=2"

    request {
        url "/customer/2"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 2,
                name: "Mauro",
                surname: "Perez"
        )
    }
}


