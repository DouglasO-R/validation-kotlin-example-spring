package com.oliveira.validation.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PersonForm(
    @field:NotNull
    @field:Size(min = 2, max = 30)
    var name: String? ,

    @field:NotNull
    @field:Min(18)
    var age: Int?
    ){

    override fun toString(): String {
        return "Person: \n " +
                "Name: $name\n" +
                "Age: $age\n"
    }
}
