# Flocking Simulation / Boids
#### This is a simple Android app, completely writtern in Kotlin to simulate flocking behavior based on Craig Reynolds's [Boids](https://www.red3d.com/cwr/boids/) algorithm.


[[Wikipedia]](https://en.wikipedia.org/wiki/Boids) Boids (which refers to a bird-like object) is an example of emergent behavior; that is, the complexity of Boids arises from the interaction of individual agents (the boids, in this case) adhering to a set of simple rules. The rules applied in the simplest Boids world are as follows:
* __Separation__: Steer to avoid crowding local flockmates
* __Alignment__: Steer towards the average heading of local flockmates
* __Cohesion__: Steer to move towards the average position (center of mass) of local flockmates

### Demo
<img src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/demo.gif" alt="Demo gif" 
data-canonical-src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/demo.gif" width="270" height="585" />

### Adjust the coefficients for the three rules for different behaviors.
<img src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/all.gif" alt="All controlls gif" 
data-canonical-src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/all.gif" width="270" height="585" />

| Only separation | Only alignment | Only cohesion | 
| -- | -- |--|
| <img src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/seperation.gif" alt="All controlls gif" data-canonical-src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/seperation.gif" width="270" height="585" />| <img src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/alignment.gif" alt="All controlls gif" data-canonical-src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/alignment.gif" width="270" height="585" />| <img src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/cohesion.gif" alt="All controlls gif" data-canonical-src="https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/demo/cohesion.gif" width="270" height="585" /> |

### Logic
* All the behaviors are abstracted behind [FlockBehavior](https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/app/src/main/java/com/digitalcrafts/flockingsimulation/logic/behaviors/FlockBehavior.kt) interface.
* All the applied behaviors are determined from [FlockBehaviorProcessor](https://github.com/JayaSuryaT/FlockingSimulation/blob/dev/app/src/main/java/com/digitalcrafts/flockingsimulation/logic/behaviors/FlockBehaviorProcessor.kt) class, you may add / modify / remove any behavior easily from here as desired.


# Thanks
Thanks to Daniel Shiffman for his awesome video about [boids / flocking simulation](https://thecodingtrain.com/CodingChallenges/124-flocking-boids).
