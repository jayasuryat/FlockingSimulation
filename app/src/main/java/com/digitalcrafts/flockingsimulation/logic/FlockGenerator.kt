package com.digitalcrafts.flockingsimulation.logic

import android.util.Log
import com.digitalcrafts.flockingsimulation.common.Constants.GLOBAL_TAG
import com.digitalcrafts.flockingsimulation.common.MathUtils.randomUnsignedFloat
import com.digitalcrafts.flockingsimulation.models.*
import kotlin.random.Random

class FlockGenerator(
    private val numberOfBoids: Int,
    private val height: Float,
    private val width: Float,
) {

    fun generate(): FlockSnapshot = generateFlock()

    private fun generateFlock(): FlockSnapshot {

        val boids = (0 until numberOfBoids).map { _ ->

            val direction = Direction.of(Random.nextFloat() * 360)

            Boid(
                position = Position(
                    x = Random.nextFloat() * width,
                    y = Random.nextFloat() * height,
                ),
                speed = Vector2d(
                    x = randomUnsignedFloat() * MAX_SPEED,
                    y = randomUnsignedFloat() * MAX_SPEED,
                ),
                acceleration = Vector2d(
                    x = randomUnsignedFloat() * MAX_ACCELERATION,
                    y = randomUnsignedFloat() * MAX_ACCELERATION,
                ),
                maxSpeed =/* randomUnsignedFloat() **/ MAX_SPEED,
                maxAcceleration = /*randomUnsignedFloat() **/ MAX_ACCELERATION
            )
        }

        val snapShot = FlockSnapshot(frame = 0, boids = boids, width = width, height = height)
        Log.d(GLOBAL_TAG, "generated snapshot : ${snapShot.prettyToString()}")
        return snapShot
    }

    private fun generateFlock2(): FlockSnapshot {

        val boids = (0 until numberOfBoids).map { _ ->

            val direction = Direction.of(90f)

            Boid(
                position = Position(
                    x = Random.nextFloat() * width,
                    y = Random.nextFloat() * height,
                ),
                speed = Vector2d(
                    x = 1f,
                    y = 1f,
                ),
                acceleration = Vector2d(
                    x = 1f,
                    y = 1f,
                ),
                maxSpeed = MAX_SPEED,
                maxAcceleration = MAX_ACCELERATION
            )
        }

        val snapShot = FlockSnapshot(frame = 0, boids = boids, width = width, height = height)
        Log.d(GLOBAL_TAG, "generated snapshot : ${snapShot.prettyToString()}")
        return snapShot
    }

    companion object {

        private const val MAX_SPEED: Float = 10f
        private const val MAX_ACCELERATION: Float = 5f
    }
}