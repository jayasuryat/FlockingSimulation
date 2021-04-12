package com.digitalcrafts.flockingsimulation.logic.behaviors

import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

class FlockBehaviorProcessor {

    private val behaviors: List<FlockBehavior> = listOf(
        FrameIncrement(),
        Alignment(),
        Cohesion(),
        Separation(),
        Nudger(),
        EdgeChecker()
    )

    fun process(snapshot: FlockSnapshot): FlockSnapshot =
        behaviors.fold(snapshot) { snap, behavior ->
            behavior.nextFrameFor(snap)
        }
}