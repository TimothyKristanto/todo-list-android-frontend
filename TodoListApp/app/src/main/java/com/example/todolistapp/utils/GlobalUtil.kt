package com.example.todolistapp.utils

import com.example.todolistapp.repositories.NetworkUserRepository
import com.example.todolistapp.repositories.UserRepository

object GlobalUtil {
    suspend fun resetUsernameToken(userRepository: UserRepository) {
        userRepository.saveUserToken("Unknown")
        userRepository.saveUsername("Unknown")
    }
}