package com.fedorov.andrii.andriiovych.tenseconds

class Stopwatch {
    private var startTime = 0L
    private var isRunning = false

    fun start() {
        startTime = System.currentTimeMillis()
        isRunning = true
    }

    fun stop() {
        isRunning = false
    }

  fun getTime(): Long {
        return System.currentTimeMillis() - startTime
    }

}