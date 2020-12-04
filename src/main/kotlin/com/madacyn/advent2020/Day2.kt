package com.madacyn.advent2020

import com.madacyn.getInput

/**
 * Advent of Code Day 2: https://adventofcode.com/2020/day/2
 */
class Day2(input: String, delimiter: String = "\n") {

    private val regex = """^(?<minRange>\d+)-(?<maxRange>\d+) (?<character>\w): (?<password>\w+)$""".toRegex()

    // Parse into a Triple of (Accepted Range, Character, Password)
    private val parsedInput = input.split(delimiter.toRegex()).mapNotNull { regex.matchEntire(it)?.groups }.map {
        Triple( // TODO: Using a Triple is confusing with all the first, second, and third names. Using a data class would be better
            it["minRange"]!!.value.toInt()..it["maxRange"]!!.value.toInt(), // Create IntRange from min/max
            it["character"]!!.value[0],
            it["password"]!!.value
        )
    }

    fun puzzle1(): Int = parsedInput.count { entry ->
        entry.third.count { it == entry.second } in entry.first
    }

    fun puzzle2(): Int = parsedInput.count { entry ->
        (entry.third[entry.first.first - 1] == entry.second) xor (entry.third[entry.first.last - 1] == entry.second)
    }

}

fun main() {
    println(Day2(getInput("day2")).puzzle1())
    println(Day2(getInput("day2")).puzzle2())
}