package com.digitalcrafts.flockingsimulation.models

data class Boid(
    val position: Position,
    val speed: Vector,
    val acceleration: Vector,
    val maxSpeed: Float,
    val maxAcceleration: Float,
) {

    fun prettyToString(): String =
        "[${position.x},${position.y}] @ ${speed.magnitude}p/s with ${speed.direction.angle}°"
}