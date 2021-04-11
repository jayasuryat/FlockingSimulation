package com.digitalcrafts.flockingsimulation.models

import kotlin.math.pow
import kotlin.math.sqrt

data class Position(
    val x: Float,
    val y: Float,
) {

    fun distanceFrom(point: Position): Float = sqrt((x - point.x).pow(2) + (y - point.y).pow(2))

    operator fun plus(velocity: Vector2d): Position = Position(
        x = x + velocity.x,
        y = y + velocity.y
    )
}