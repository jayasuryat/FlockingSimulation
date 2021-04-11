package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.models.Boid
import com.digitalcrafts.flockingsimulation.models.FlockSnapshot
import com.digitalcrafts.flockingsimulation.models.Vector2d

class Alignment : FlockBehavior {

    override fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot =
        alignBoids(flockSnapshot)

    private fun alignBoids(source: FlockSnapshot): FlockSnapshot = source.copy(
        boids = source.boids.map { boid -> boid.copy(acceleration = boid.align(source.boids)) }
    )

    private fun Boid.align(flock: List<Boid>): Vector2d {

        val boid = this
        var total = 0
        var steering = Vector2d(0f, 0f)

        flock.forEach { other ->

            val distance = boid.position.distanceFrom(other.position)

            if (distance < PERCEPTION_RADIUS && boid != other) {
                total++
                steering += other.speed
            }
        }

        return if (total == 0) boid.acceleration
        else {
            steering /= Vector2d(total.toFloat(), total.toFloat())
            steering = steering.withMagnitude(boid.maxAcceleration)
            steering - boid.speed
            steering = steering.withLimit(boid.maxAcceleration)
            steering
        }
    }

    companion object {

        private const val PERCEPTION_RADIUS: Float = 100f
    }
}