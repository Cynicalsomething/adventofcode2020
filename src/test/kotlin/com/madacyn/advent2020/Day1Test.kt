package com.madacyn.advent2020

import com.madacyn.getInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class Day1Test {

    private lateinit var day1: Day1

    @BeforeEach
    fun setup() {
        day1 = Day1(getInput("day1"))
    }

    @Test
    fun `Day 1 example 1`() {
        Assertions.assertEquals(514579, day1.puzzle1())
    }

    @Test
    fun `Day 1 example 2`() {
        Assertions.assertEquals(241861950, day1.puzzle2())
    }
}