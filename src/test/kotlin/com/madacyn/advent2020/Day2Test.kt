package com.madacyn.advent2020

import com.madacyn.getInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {

    private val day2 = Day2(getInput("day2"))

    @Test
    fun `Day 2 example 1`() {
        assertEquals(2, day2.puzzle1())
    }

    @Test
    fun `Day 2 example 2`() {
        assertEquals(1, day2.puzzle2())
    }
}