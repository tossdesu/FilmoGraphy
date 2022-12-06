package com.tossdesu.memofilm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tossdesu.memofilm.R
import com.tossdesu.memofilm.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAccountBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}