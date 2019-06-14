package com.glb.bootcamp.Put

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return the updated customer by name = Mike and updated id = 7"


    request {
        url "/customer/7"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 7,
                name: "Mike",
                surname: "Castro"
        )
    }
}



