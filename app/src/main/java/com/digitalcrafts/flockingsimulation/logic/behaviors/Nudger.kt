package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

class Nudger : FlockBehavior {

    override fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot =
        nudgeFlockFor(flockSnapshot)

    private fun nudgeFlockFor(source: FlockSnapshot): FlockSnapshot = source.copy(

        boids = source.boids.map { boid ->

            var newSpeed = boid.speed.add(boid.acceleration)
            if (newSpeed.magnitude > boid.maxSpeed)
                newSpeed = boid.speed.copy(magnitude = boid.maxSpeed)

            boid.copy(
                position = boid.position.add(boid.speed),
                speed = newSpeed
            )
        })
}