package com.digitalcrafts.flockingsimulation.models

import com.digitalcrafts.flockingsimulation.common.MathUtils.radiansToAngle
import kotlin.math.*

data class Vector(
    val magnitude: Float,
    val direction: Direction,
) {

    fun add(vector: Vector): Vector {

        val a = this
        val b = vector

        val angleInBetween = a.direction.angle - b.direction.angle

        val newMag = sqrt(
            a.magnitude.pow(2) +
                    b.magnitude.pow(2) +
                    (2 * a.magnitude * b.magnitude * cos(angleInBetween))
        )

        val newAngleInRadians = atan(
            (a.magnitude * sin(angleInBetween)) /
                    (b.magnitude + a.magnitude * cos(angleInBetween))
        )

        val newAngle = radiansToAngle(newAngleInRadians) + a.direction.angle

        return Vector(
            magnitude = newMag,
            direction = Direction.of(newAngle)
        )
    }
}

