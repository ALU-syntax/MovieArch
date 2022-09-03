package com.ardian.moviearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.ardian.moviearch.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //animate atas
        val animate1 = AnimationUtils.loadAnimation(this, R.anim.top_wave)
        binding.ivTop.startAnimation(animate1)

        //animate bawah
        val animate2 = AnimationUtils.loadAnimation(this, R.anim.bottom_wave)
        binding.ivBottom.startAnimation(animate2)

        //rotate animate
        val animate3 = AnimationUtils.loadAnimation(this, R.anim.rotate)
        binding.ivRoll.startAnimation(animate3)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4500)
    }


}