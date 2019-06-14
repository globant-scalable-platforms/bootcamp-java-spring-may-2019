package com.glb.bootcamp.GET

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should failed the test"

    request {
        url "/customer/3"
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
                surname: "Pelaez"
        )
    }
}


