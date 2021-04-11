package com.digitalcrafts.flockingsimulation.models

data class FlockSnapshot(
    val frame: Int,
    val boids: List<Boid>,
    var height: Float,
    var width: Float,
) {

    val size: Int = boids.size

    fun prettyToString(): String {
        val str = StringBuilder()
        str.append("Frame : $frame, boids = [\n")
        boids.forEach { str.append(it.prettyToString() + " ,\n") }
        str.append("]\n")
        return str.toString()
    }
}