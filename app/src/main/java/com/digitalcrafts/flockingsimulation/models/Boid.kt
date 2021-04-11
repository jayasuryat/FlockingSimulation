package com.digitalcrafts.flockingsimulation.models

import kotlin.math.sqrt

data class Boid(
    val position: Position,
    val speed: Vector2d,
    val acceleration: Vector2d,
    val maxSpeed: Float,
    val maxAcceleration: Float,
) {

    fun prettyToString(): String =
        "[${position.x},${position.y}] @ ${speed.prettyToString()}p/s°"
}