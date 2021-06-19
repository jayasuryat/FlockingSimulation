package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.logic.defintions.FlockBehavior
import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

class Nudger : FlockBehavior {

    override fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot =
        nudgeFlockFor(flockSnapshot)

    private fun nudgeFlockFor(source: FlockSnapshot): FlockSnapshot = source.copy(

        boids = source.boids.map { boid ->

            val newSpeed = (boid.speed + boid.acceleration).withLimit(boid.maxSpeed)
            boid.copy(
                position = boid.position + boid.speed,
                speed = newSpeed,
                acceleration = boid.acceleration * 0f
            )
        })
}