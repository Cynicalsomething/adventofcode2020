package com.madacyn.advent2020

import com.madacyn.getInput

class Day6(input: String, delimiter: String = "\n\n") {

    private val groupAnswers = input.split(delimiter.toRegex())

    fun puzzle1() = groupAnswers.map { it.replace("\n", "").toSet() }.sumBy { it.size }

    fun puzzle2() = groupAnswers.map { it.split("\n") // Split into individual answers in a group
        .map { individualAnswers -> individualAnswers.toSet() } } // Transform to a set of Chars
        .sumBy { it.fold(it[0], { set, next -> next.intersect(set) }).size } // Intersect all individual answers to find # of common answers

}

fun main() {
    val day6 = Day6(getInput("day6"))
    println(day6.puzzle1()) // 6742
    println(day6.puzzle2()) // 3447
}