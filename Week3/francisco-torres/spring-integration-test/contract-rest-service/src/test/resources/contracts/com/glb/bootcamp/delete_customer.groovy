package com.glb.bootcamp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should delete a customer"

    request {
        method DELETE()
        url "/customers/1"
    }

    response {
        status OK()
    }
}
