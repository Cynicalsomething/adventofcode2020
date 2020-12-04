package com.madacyn

import java.io.FileNotFoundException

internal object Resources

fun getInput(filename: String): String = Resources::class.java.classLoader.getResource("$filename.txt")?.readText() ?: throw FileNotFoundException()