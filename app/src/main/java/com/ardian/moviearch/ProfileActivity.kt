package com.ardian.moviearch

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardian.moviearch.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ivGithub.setOnClickListener{
            val uri = Uri.parse("https://github.com/ALU-syntax")
            try {
                Intent(Intent.ACTION_VIEW, uri).apply {
                    setPackage("com.github.android")
                    startActivity(this)
                }
            } catch (e : ActivityNotFoundException){
                Intent(Intent.ACTION_VIEW, uri).apply {
                    startActivity(this)
                }
            }
        }

        binding.ivTwitter.setOnClickListener {
            val uri = Uri.parse("https://twitter.com/mengkerebe")
            try {
                Intent(Intent.ACTION_VIEW, uri).apply {
                    setPackage("com.twitter.android")
                    startActivity(this)
                }
            } catch (e : ActivityNotFoundException){
                Intent(Intent.ACTION_VIEW, uri).apply {
                    startActivity(this)
                }
            }
        }

        binding.ivInstagram.setOnClickListener {
            val uri = Uri.parse("https://instagram.com/ardian_iqbal_?igshid=YmMyMTA2M2Y=")
            try {
                Intent(Intent.ACTION_VIEW, uri).apply {
                    setPackage("com.instagram.android")
                    startActivity(this)
                }
            } catch (e : ActivityNotFoundException){
                Intent(Intent.ACTION_VIEW, uri).apply {
                    startActivity(this)
                }
            }
        }

        binding.ivLinkedin.setOnClickListener {
            val uri = Uri.parse("https://www.linkedin.com/in/ardianiqbal/")
            try {
                Intent(Intent.ACTION_VIEW, uri).apply {
                    setPackage("com.linkedin.android")
                    startActivity(this)
                }
            } catch (e : ActivityNotFoundException){
                Intent(Intent.ACTION_VIEW, uri).apply {
                    startActivity(this)
                }
            }

        }


        binding.btnBack.setOnClickListener{
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}