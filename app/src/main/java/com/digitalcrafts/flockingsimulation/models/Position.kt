package com.digitalcrafts.flockingsimulation.models

import com.digitalcrafts.flockingsimulation.common.MathUtils.angleInRad
import kotlin.math.cos
import kotlin.math.sin

data class Position(
    val x: Float,
    val y: Float,
) {

    fun add(velocity: Vector): Position {
        val newX: Float = (cos(angleInRad(velocity.direction.angle))) + x
        val newY: Float = (velocity.magnitude * sin(angleInRad(velocity.direction.angle))) + y
        return Position(newX, newY)
    }

    companion object {

        fun atOrigin(): Position = Position(0f, 0f)
    }
}