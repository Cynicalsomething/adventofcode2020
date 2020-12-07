package com.madacyn.advent2020

import com.madacyn.getInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun `Day 4 example 1`() = assertEquals(2, Day4(getInput("day4")).puzzle1())

    @Test
    fun `Day 4 example 2 valid`() = assertEquals(4, Day4(getInput("day4example2")).puzzle2())
}