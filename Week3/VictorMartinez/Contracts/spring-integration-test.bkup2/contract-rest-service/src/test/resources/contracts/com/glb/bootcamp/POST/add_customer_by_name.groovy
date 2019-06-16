package com.glb.bootcamp.POST


import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description( "should add a customer by name = Thomas")

    request {
        method POST()
        url "/customer/name"
    }

    response {
        status OK()
        body (
                "id": 5,
                "name": "Thomas",
                "surname": "Pelaez"
        )
        headers {
            contentType('application/json')
        }
    }
}

