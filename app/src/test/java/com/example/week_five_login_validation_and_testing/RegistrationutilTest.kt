package com.example.week_five_login_validation_and_testing

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RegistrationUtilTest{

    @Test
    fun `when username is empty`(){
        val result = RegistrationUtil.validateInput("","anyemail@email.com", "09079012345")
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `when email is empty`(){
        val result = RegistrationUtil.validateInput("stubborn","", "09079012345")
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `when phone is empty`(){
        val result = RegistrationUtil.validateInput("stubborn","anyemail@email.com", "")
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `when email is not a valid type`(){
        val result = RegistrationUtil.validateInput("stubborn","anyone", "09079012345")
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `when phone number is not valid`(){
        val result = RegistrationUtil.validateInput("stubborn","anyemail@email.com", "18079012345")
        assertThat(result).isEqualTo(false)
    }
}