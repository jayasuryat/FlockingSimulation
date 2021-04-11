package com.digitalcrafts.flockingsimulation.models

data class Position(
    val x: Float,
    val y: Float,
) {

    operator fun plus(velocity: Vector2d): Position = Position(
        x = x + velocity.x,
        y = y + velocity.y
    )

    companion object {

        fun atOrigin(): Position = Position(0f, 0f)
    }
}