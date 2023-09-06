package com.example.flowpractice

import android.icu.number.Notation.simple
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
//    // Launch a concurrent coroutine to check if the main thread is blocked
//    launch {
//        for (k in 1..3) {
//            println("I'm not blocked $k")
//            delay(100)
//        }
    println("Calling simple function...")
    val flow = simple()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }

    }
    // Collect the flow
//    simple().collect { value -> println(value) }


//
//fun simple(): Sequence<Int> = sequence { // sequence builder
//    for (i in 1..3) {
//        Thread.sleep(100) // pretend we are computing it
//        yield(i) // yield next value
//    }
//}


fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}



