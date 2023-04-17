package com.fedorov.andrii.andriiovych.tenseconds

fun main() {
    val stopwatch = Stopwatch()
    stopwatch.start()
    for (x in 0..10){
        Thread.sleep(10)
        println(stopwatch.getTime())
    }
    stopwatch.stop()
    stopwatch.start()
    for (x in 0..10){
        Thread.sleep(10)
        println(stopwatch.getTime())
    }
    stopwatch.stop()
}