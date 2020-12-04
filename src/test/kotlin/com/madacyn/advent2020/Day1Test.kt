package com.madacyn.advent2020

import com.madacyn.getInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class Day1Test {

    private var day1 = Day1(getInput("day1"))

    @Test
    fun `Day 1 example 1`() {
        assertEquals(514579, day1.puzzle1())
    }

    @Test
    fun `Day 1 example 2`() {
        assertEquals(241861950, day1.puzzle2())
    }
}