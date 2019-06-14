package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer by id=4"

    request {
        url "/customer"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                name: "Santi",
                surename: "Vasquez",
        )
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                id: 4,
                name: "Santi",
                surname: "Vasquez"
        )
    }
}