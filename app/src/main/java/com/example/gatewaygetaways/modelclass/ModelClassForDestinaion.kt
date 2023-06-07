package com.example.gatewaygetaways.modelclass

import java.nio.channels.spi.AbstractSelectionKey

class ModelClassForDestinaion {

    lateinit var image: String
    lateinit var location: String
    lateinit var name: String
    lateinit var amount: String
    lateinit var rateing: String
    lateinit var info: String
     var status: Int = 0


    constructor(
        image: String,
        location: String,
        name: String,
        amount: String,
        rateing: String,
        info: String,
        status: Int
    ) {

        this.image = image
        this.location = location
        this.name = name
        this.amount = amount
        this.rateing = rateing
        this.info = info
        this.status = status

    }

    constructor() {

    }
}