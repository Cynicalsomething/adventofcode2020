package com.madacyn.advent2020

import com.madacyn.getInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day6Test {

    private val day6 = Day6(getInput("day6"))

    @Test
    fun `Day 6 example 1`() = assertEquals(11, day6.puzzle1())

    @Test
    fun `Day 6 example 2`() = assertEquals(6, day6.puzzle2())
}