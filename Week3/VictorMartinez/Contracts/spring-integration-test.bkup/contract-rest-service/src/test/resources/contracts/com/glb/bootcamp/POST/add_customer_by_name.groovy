package com.glb.bootcamp.POST

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return the added customer by name=luis"

    request {
        url "/customer/Luis"
        method POST()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 5,
                name: "Luis",
                surname: "Jackson"
        )
    }
}



