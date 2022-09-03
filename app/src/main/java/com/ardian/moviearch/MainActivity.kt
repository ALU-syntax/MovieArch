package com.ardian.moviearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ardian.moviearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //setting toolbar
        setSupportActionBar(binding.toolbar)

        binding.btnSearch.setOnClickListener{
            showFragment()
        }
    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = FragmentData()

        var resultText = binding.edMovie.text
        var mBundle = Bundle()
        mBundle.putString("carimovie", resultText.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_fragment, mFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.profile -> {
            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }
}