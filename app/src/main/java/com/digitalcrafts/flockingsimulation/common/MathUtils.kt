package com.digitalcrafts.flockingsimulation.common

import kotlin.random.Random

object MathUtils {

    fun angleInRad(angle: Float): Float = angle * (Math.PI.toFloat() / 180f)

    fun radiansToAngle(angle: Float): Float = angle * 180f / Math.PI.toFloat()

    fun randomUnsignedFloat(): Float = Random.nextFloat() * (if (Random.nextBoolean()) 1f else -1f)
}