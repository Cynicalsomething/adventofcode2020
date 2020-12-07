package com.madacyn.advent2020

import com.madacyn.getInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day3Test {

    private val day3 = Day3(getInput("day3"))

    @Test
    fun `Day 3 example 1`() = assertEquals(7, day3.puzzle1())

    @Test
    fun `Day 3 example 2`() = assertEquals(336, day3.puzzle2())
}