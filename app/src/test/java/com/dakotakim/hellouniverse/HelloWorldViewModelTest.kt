package com.dakotakim.hellouniverse

import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class HelloWorldViewModelTest {
    private lateinit var sut: HelloWorldViewModel

    @Before
    fun setUp() {
        sut = HelloWorldViewModel()
    }

    @Test
    fun onGreetActionClicked() {
        // Asserts that greetingText == ""
        assertThat(sut.greetingText.get(), `is`(""))

        sut.personName.set("General Kenobi")
        sut.onGreetActionClicked()

        assertThat(sut.greetingText.get(), `is`("Hello, General Kenobi"))
    }

    @Test
    fun onGoodbyeActionClicked() {
        assertThat(sut.greetingText.get(), `is`(""))

        sut.personName.set("General Kenobi")
        sut.onGoodbyeActionClicked()

        assertThat(sut.greetingText.get(), `is`("Goodbye, General Kenobi"))
    }
}