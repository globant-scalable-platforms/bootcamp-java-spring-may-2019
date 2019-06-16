package com.glb.bootcamp.PUT

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should update a customer by Id = 1"

    request {
        method PUT()
        url  "/customer/id/1"
        body(
                id:1L,
                name:"Mike",
                surname:"Castro"
        )
        headers{
            contentType("application/json")
        }

    }

    response {
        status OK()
        body (
                id: 1L,
                name: "Mike",
                surname: "Gutierrez"
        )
        headers {
            contentType('application/json')
        }
    }
}

