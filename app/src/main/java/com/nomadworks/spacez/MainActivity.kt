package com.nomadworks.spacez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nomadworks.spacez.databinding.ActivityMainBinding
import com.nomadworks.spacez.launch.LaunchInfoActivity

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.btnLaunch.setOnClickListener {
            startActivity(
                Intent(this, LaunchInfoActivity::class.java)
            )
        }
    }
}