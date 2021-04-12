package com.digitalcrafts.flockingsimulation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.digitalcrafts.flockingsimulation.common.Constants.GLOBAL_TAG
import com.digitalcrafts.flockingsimulation.views.FlockBox
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {

        fun getFlockBox(): FlockBox? = findViewById(R.id.fbFlock)

        findViewById<ImageView>(R.id.ivControllersToggle)?.setOnClickListener {
            val view = findViewById<ConstraintLayout>(R.id.clControllers)
            if (view?.visibility == View.VISIBLE) view.visibility = View.GONE
            else view?.visibility = View.VISIBLE
        }

        findViewById<Slider>(R.id.sbAlignment)?.addOnChangeListener { _, value, _ ->
            Log.d(GLOBAL_TAG, "alignmentCoefficient = $value")
            getFlockBox()?.setAlignmentCoefficient(value)
        }

        findViewById<Slider>(R.id.sbCohesion)?.addOnChangeListener { _, value, _ ->
            Log.d(GLOBAL_TAG, "cohesionCoefficient = $value")
            getFlockBox()?.setCohesionCoefficient(value)
        }

        findViewById<Slider>(R.id.sbSeparation)?.addOnChangeListener { _, value, _ ->
            Log.d(GLOBAL_TAG, "separationCoefficient = $value")
            getFlockBox()?.setSeparationCoefficient(value)
        }
    }
}