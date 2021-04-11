package com.digitalcrafts.flockingsimulation.common

object MathUtils {

    fun angleInRad(angle: Float): Float = angle * (Math.PI.toFloat() / 180f)

    fun radiansToAngle(angle: Float): Float = angle * 180f / Math.PI.toFloat()
}