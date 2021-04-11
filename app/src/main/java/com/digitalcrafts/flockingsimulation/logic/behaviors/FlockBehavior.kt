package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

interface FlockBehavior {

    fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot
}
