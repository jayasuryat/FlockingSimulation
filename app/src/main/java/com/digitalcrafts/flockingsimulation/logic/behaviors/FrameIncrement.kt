package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.logic.defintions.FlockBehavior
import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

class FrameIncrement : FlockBehavior {

    override fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot =
        flockSnapshot.copy(frame = flockSnapshot.frame + 1)
}