package com.kotlin.restapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User {

    @Id
    val id: String? = null
    var name: String? = null
    var email: String? = null
    var password: String? = null
}