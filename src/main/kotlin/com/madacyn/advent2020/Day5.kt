package com.madacyn.advent2020

import com.madacyn.getInput
import java.security.InvalidParameterException

/**
 * Advent of Code Day 4: https://adventofcode.com/2020/day/4
 *
 * Todd Ginsberg came up with a very cool solution to this: https://todd.ginsberg.com/post/advent-of-code/2020/day5/
 */
class Day5(input: String, delimiter: String = "\n") {

    private val parsedInput = input.split(delimiter.toRegex())

    private val rowRange = 0..127
    private val columnRange = 0..7

    fun puzzle1() = parsedInput.map { findSeatId(it) }.maxOrNull()

    fun puzzle2() =
        parsedInput.map { findSeatId(it) }.sorted().zipWithNext().first { it.second - it.first != 1 }.first + 1

    private fun findSeatId(seatPath: String) =
        pinPoint(seatPath.substring(0..seatPath.length - 4), rowRange) * 8 + pinPoint(
            seatPath.substring(seatPath.length - 3),
            columnRange
        )

    private fun pinPoint(seatPath: String, range: IntRange): Int =
        if (seatPath.isBlank()) range.first
        else pinPoint(
            seatPath.substring(1),
            when (seatPath[0]) {
                'F', 'L' -> range.first..(range.first + ((range.last - range.first) / 2)) // First half of range
                'B', 'R' -> ((range.first + ((range.last - range.first) / 2)) + 1)..range.last // Second half of range
                else -> throw InvalidParameterException()
            }
        )

}

fun main() {
    val day5 = Day5(getInput("day5"))
    println(day5.puzzle1()) // 970
    println(day5.puzzle2()) // 587

}