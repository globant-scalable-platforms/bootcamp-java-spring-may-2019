package com.glb.bootcamp.POST

import org.springframework.cloud.contract.spec.Contract


Contract.make {

    description "should add a customer by id = 4"

    request {
        method POST()
        url "/customer/id"
        body(
                id:4,
                name:"Felipe",
                surname:"Martinez"
        )
        headers {
                contentType applicationJson()
        }

    }

    response {
        status OK()
        body (
                id: 4,
                name: "Felipe",
                surname: "Martinez"
        )
        headers {
            contentType applicationJson()
        }
    }
}
