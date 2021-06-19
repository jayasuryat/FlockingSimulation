package com.digitalcrafts.flockingsimulation.logic.defintions

import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

interface FlockBehavior {

    fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot
}
