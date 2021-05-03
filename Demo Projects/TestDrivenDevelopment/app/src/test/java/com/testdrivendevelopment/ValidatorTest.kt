package com.testdrivendevelopment

import com.google.common.truth.Truth.assertThat
import com.testdrivendevelopment.ui.Validator
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whenValidInput() {
        val amount = 100
        val desc = "Random text"
        val result = Validator.validateInput(amount, desc)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInValidInput() {
        val amount = 0
        val desc = ""
        val result = Validator.validateInput(amount, desc)
        assertThat(result).isEqualTo(false)
    }

}