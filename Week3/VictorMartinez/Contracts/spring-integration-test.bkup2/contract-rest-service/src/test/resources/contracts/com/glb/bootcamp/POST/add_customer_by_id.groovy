package com.glb.bootcamp.POST

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should add a customer by Id = 4"

    request {
        method POST()
        url  "/customer/id"
    }

    response {
        status OK()
        body (
                id: 4,
                name: "William",
                surname: "Diaz"
        )
        headers {
            contentType('application/json')
        }
    }
}
