package com.digitalcrafts.flockingsimulation.models

import kotlin.math.abs

data class Direction(val angle: Float) {

    init {
        if (angle < 0f || angle > 360f) throw IllegalArgumentException("Angle ($angle) out of range")
    }

    companion object {

        fun of(angle: Float): Direction {
            val in360 = angle % 360f
            val absAngle = if (in360 < 0) 360f - abs(in360) else in360
            return Direction(absAngle)
        }
    }
}