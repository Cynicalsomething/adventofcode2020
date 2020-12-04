package com.madacyn.advent2020

import com.madacyn.getInput

/**
 * Advent of Code Day 1: https://adventofcode.com/2020/day/1
 */
class Day1(input: String, delimiter: String = "\n") {

    private val parsedInput = input.split(delimiter.toRegex()).map { it.trim().toInt() }.sorted()

    fun puzzle1(): Int =
        parsedInput.mapIndexedNotNull { i, one ->
            parsedInput.drop(i + 1).firstOrNull { two -> one + two == 2020 }?.times(one)
        }.first()

    // May be able to use a recursive higher order function here
    fun puzzle2(): Int =
        parsedInput.mapIndexedNotNull { i, one ->
            parsedInput.drop(i + 1).mapIndexedNotNull { j, two ->
                parsedInput.drop(j + 1).firstOrNull { three -> one + two + three == 2020 }?.times(two)
            }.firstOrNull()?.times(one)
        }.first()
}

fun main() {
    val day1 = Day1(getInput("day1"))
    println(day1.puzzle1()) // 713184
    println(day1.puzzle2()) // 261244452
}