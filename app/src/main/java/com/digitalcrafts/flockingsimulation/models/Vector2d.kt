package com.digitalcrafts.flockingsimulation.models

import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

data class Vector2d(
    val x: Float,
    val y: Float,
) {

    val magnitude: Float by lazy { sqrt(x.pow(2) + y.pow(2)) }

    fun prettyToString(): String = "v[$x,$y]"

    fun withLimit(limit: Float): Vector2d {

        if (x.absoluteValue < limit && y.absoluteValue < limit) return this.copy()

        val isXNegative = x < 0f
        val isYNegative = y < 0f

        val newX = if (x.absoluteValue < limit) x
        else limit.absoluteValue * (if (isXNegative) -1f else 1f)
        val newY = if (y.absoluteValue < limit) y
        else limit.absoluteValue * (if (isYNegative) -1f else 1f)

        return Vector2d(
            x = newX,
            y = newY
        )
    }

    fun withMagnitude(requiredMagnitude: Float): Vector2d {
        val x = (x / magnitude) * requiredMagnitude
        val y = (y / magnitude) * requiredMagnitude
        return Vector2d(
            x = x,
            y = y
        )
    }

    operator fun plus(vector: Vector2d): Vector2d = Vector2d(
        x = x + vector.x,
        y = y + vector.y,
    )

    operator fun minus(vector: Vector2d): Vector2d = Vector2d(
        x = x - vector.x,
        y = y - vector.y,
    )

    operator fun times(vector: Vector2d): Vector2d = Vector2d(
        x = x * vector.x,
        y = y * vector.y,
    )

    operator fun div(vector: Vector2d): Vector2d = Vector2d(
        x = x / vector.x,
        y = y / vector.y,
    )
}
