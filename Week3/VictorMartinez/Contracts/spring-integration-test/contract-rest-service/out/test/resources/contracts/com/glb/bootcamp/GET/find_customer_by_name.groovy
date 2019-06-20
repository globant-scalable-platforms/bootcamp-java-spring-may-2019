package com.glb.bootcamp.GET

Contract.make {
    description "should return customer by name = Mauro"

    request {
        url "/customer/name/Mike"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 1,
                name: "Mike",
                surname: "Castro"
        )
    }
}
