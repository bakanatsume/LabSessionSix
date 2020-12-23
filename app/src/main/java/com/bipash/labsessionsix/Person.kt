package com.bipash.labsessionsix

import java.io.Serializable
import java.util.concurrent.atomic.DoubleAdder

class Person:Serializable {
    var name : String
    var address : String
    var phoneNumber : String
    var gender : String

    constructor(name:String,address:String,phoneNumber:String,gender:String){
        this.name = name;
        this.address = address
        this.phoneNumber = phoneNumber
        this.gender = gender
    }

    override fun toString(): String {
        return name
    }
}