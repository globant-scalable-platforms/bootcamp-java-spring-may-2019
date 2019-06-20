package com.glb.bootcamp.DELETE



import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should update a customer by id = 2"

    request {
        method DELETE()
        url "/customer/id/2"
        body(
                id:2,
                name:"Mauro",
                surname:"Perez"
        )
        headers {
            contentType applicationJson()
        }

    }

    response {
        status OK()

        body(
                id:0,
                name:"-",
                surname:"-"
        )
        headers {
            contentType applicationJson()
        }
    }

}


