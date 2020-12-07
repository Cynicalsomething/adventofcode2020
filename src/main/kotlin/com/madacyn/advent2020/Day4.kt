package com.madacyn.advent2020

import com.madacyn.getInput

/**
 * Advent of Code Day 4: https://adventofcode.com/2020/day/4
 */
class Day4(input: String, delimiter: Regex = """\n\n""".toRegex()) {

    private val parsedInput = input.split(delimiter).map {
        it.replace('\n', ' ').split(' ').associate { pair ->
            val (left, right) = pair.split(':')
            left to right
        }
    }

    private val expectedFields = mapOf<String, (String) -> Boolean>(
        "byr" to { it.length == 4 && it.toInt() in 1920..2002 },
        "iyr" to { it.length == 4 && it.toInt() in 2010..2020 },
        "eyr" to { it.length == 4 && it.toInt() in 2020..2030 },
        "hgt" to {
            """^\d+(cm|in)$""".toRegex().matches(it) && when (it.substring(it.length - 2)) {
                "cm" -> it.substring(0, it.length - 2).toInt() in 150..193
                "in" -> it.substring(0, it.length - 2).toInt() in 59..76
                else -> false
            }
        },
        "hcl" to { """^#[0-9a-f]{6}$""".toRegex().matches(it) },
        "ecl" to { it in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
        "pid" to { """^\d{9}$""".toRegex().matches(it) }
    )

    fun puzzle1() = parsedInput.count { entries -> expectedFields.keys.all { it in entries } }

    fun puzzle2() = parsedInput.count { entries ->
        expectedFields.keys.all { it in entries } && entries.all { (key, value) ->
            expectedFields[key]?.invoke(value) ?: true
        }
    }

}

fun main() {
    val day4 = Day4(getInput("day4"))
    println(day4.puzzle1()) // 250
    println(day4.puzzle2()) // 158
}