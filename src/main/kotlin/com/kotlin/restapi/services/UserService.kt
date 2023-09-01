package com.kotlin.restapi.services

import com.kotlin.restapi.models.User
import com.kotlin.restapi.respositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUsers(): MutableList<User> = userRepository.findAll()

    fun getUserById(id: String) = userRepository.findById(id)

    fun createUser(user: User) = userRepository.save(user)

    fun updateUser(id: String, newUser: User) {
        val user = userRepository.findById(id).orElse(null)
        user.name = newUser.name
        user.email = newUser.email
        user.password = newUser.password
        userRepository.save(user)
    }

    fun deleteUser(id: String) = userRepository.deleteById(id)
}