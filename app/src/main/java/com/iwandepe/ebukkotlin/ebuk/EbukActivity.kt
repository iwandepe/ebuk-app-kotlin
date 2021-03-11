package com.iwandepe.ebukkotlin.ebuk

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.iwandepe.ebukkotlin.R

class EbukActivity : AppCompatActivity {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_ebuk)
    }
}