package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.models.FlockSnapshot
import com.digitalcrafts.flockingsimulation.models.Position

class EdgeChecker : FlockBehavior {

    override fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot =
        updateEdgesFor(flockSnapshot)

    private fun updateEdgesFor(source: FlockSnapshot): FlockSnapshot = source.copy(

        boids = source.boids.map { boid ->

            var newX = boid.position.x
            var newY = boid.position.y

            if (boid.position.x > source.width) newX = 0f
            if (boid.position.x < 0) newX = source.width
            if (boid.position.y > source.height) newY = 0f
            if (boid.position.y < 0) newY = source.height

            boid.copy(position = Position(x = newX, y = newY))
        }
    )
}