package com.madacyn.advent2020

import com.madacyn.getInput

/**
 * Advent of Code Day 3: https://adventofcode.com/2020/day/3
 */
class Day3(input: String, delimeter: String = "\n") {

    private val parsedInput = input.split(delimeter.toRegex())

    private val puzzle2Slopes = listOf(
        1 to 1,
        3 to 1,
        5 to 1,
        7 to 1,
        1 to 2
    )

    // Calculate number of '#' encountered with a slope of right 3, down 1
    fun puzzle1() =
        parsedInput.foldIndexed(0, { index, total, row -> total + if (row[(index * 3) % row.length] == '#') 1 else 0 })

    // Multiple slopes as determined by puzzle2Slopes
    fun puzzle2() = puzzle2Slopes.map { (right, down) ->
        parsedInput.foldIndexed(
            0,
            { index, total, row ->
                total + if (index >= down && index % down == 0 && row[((index / down * right) % row.length)] == '#') 1 else 0 // TODO: This is a bit nasty. Would be much cleaner if I further kotlin-ify this code
            })
    }.reduce { acc, i -> acc * i }
}

fun main() {
    val day3 = Day3(getInput("day3"))
    println(day3.puzzle1())
    println(day3.puzzle2())
}