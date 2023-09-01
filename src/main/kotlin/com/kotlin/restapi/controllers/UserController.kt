package com.kotlin.restapi.controllers

import com.kotlin.restapi.models.User
import com.kotlin.restapi.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/")
    fun getUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.getUsers())

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): ResponseEntity<User> = ResponseEntity.ok(userService.getUserById(id).orElse(null))

    @PostMapping("/")
    fun createUser(@RequestBody user: User): ResponseEntity<User> = ResponseEntity.ok(userService.createUser(user))

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody user: User): ResponseEntity<User> {
        userService.updateUser(id, user)
        return ResponseEntity.ok(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<String> {
        userService.deleteUser(id)
        return ResponseEntity.ok("User deleted successfully")
    }
}