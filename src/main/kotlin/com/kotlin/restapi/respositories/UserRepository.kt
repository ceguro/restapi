package com.kotlin.restapi.respositories

import com.kotlin.restapi.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String>