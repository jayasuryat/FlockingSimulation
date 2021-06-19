package com.digitalcrafts.flockingsimulation.logic.processor

import com.digitalcrafts.flockingsimulation.logic.behaviors.*
import com.digitalcrafts.flockingsimulation.logic.defintions.FlockBehavior
import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

class FlockBehaviorProcessor : FlockBehavior {

    private val behaviors: List<FlockBehavior> = listOf(
        FrameIncrement(),
        Alignment(),
        Cohesion(),
        Separation(),
        Nudger(),
        EdgeChecker()
    )

    override fun nextFrameFor(flockSnapshot: FlockSnapshot): FlockSnapshot =
        behaviors.fold(flockSnapshot) { snap, behavior ->
            behavior.nextFrameFor(snap)
        }
}