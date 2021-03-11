package com.iwandepe.ebukkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.iwandepe.ebukkotlin.databinding.ActivityMainBinding
import com.iwandepe.ebukkotlin.econews.EconewsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val intent = Intent(this, EconewsActivity::class.java)
        binding.apply {
            newsMenu.setOnClickListener {
                startActivity(intent)
                finish()
            }
        }
    }
}