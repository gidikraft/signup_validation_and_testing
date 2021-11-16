package com.example.week_five_login_validation_and_testing


object RegistrationUtil {

    fun validateInput(username: String, email: String, phone: String): Boolean {

        if (username.isBlank() || email.isBlank() || phone.isBlank()) {
            return false
        }
        if (!Regex("""\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6}""").matches(email)){
            return false
        }
        if (!Regex("^(\\+234|0)(8([01])|([79])([0]))\\d{8}$").matches(phone)){
            return false
        }
        return true
    }
}