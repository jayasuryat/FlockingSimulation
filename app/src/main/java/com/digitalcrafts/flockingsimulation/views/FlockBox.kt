package com.digitalcrafts.flockingsimulation.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.digitalcrafts.flockingsimulation.R
import com.digitalcrafts.flockingsimulation.logic.FlockGenerator
import com.digitalcrafts.flockingsimulation.logic.behaviors.FlockBehaviorProcessor
import com.digitalcrafts.flockingsimulation.models.Boid
import com.digitalcrafts.flockingsimulation.models.FlockSnapshot

class FlockBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private val boidPaint: Paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.white)
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val flockBehaviorProcessor: FlockBehaviorProcessor = FlockBehaviorProcessor()

    private var flockSnapshot: FlockSnapshot = FlockGenerator(
        numberOfBoids = 20,
        width = 500f,
        height = 500f,
    ).generate()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        flockSnapshot.height = h.toFloat()
        flockSnapshot.width = w.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        flockSnapshot.draw(canvas)
        updateSnapshot()
    }

    private fun updateSnapshot() {
        flockSnapshot = flockBehaviorProcessor.process(flockSnapshot)
        invalidate()
    }

    private fun FlockSnapshot.draw(canvas: Canvas): Unit =
        this.boids.forEach { it.draw(canvas) }

    private fun Boid.draw(canvas: Canvas): Unit =
        canvas.drawCircle(this.position.x, this.position.y, BOID_RADIUS, boidPaint)

    companion object {

        private const val BOID_RADIUS: Float = 10f
    }
}