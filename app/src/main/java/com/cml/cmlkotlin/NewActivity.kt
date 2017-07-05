package com.cml.cmlkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_new)
        LoginAnkoUI().setContentView(this@NewActivity)

        var userId = intent.getIntExtra("userId",0)
        var name = intent.getStringExtra("name")
        showToast("$userId+$name")


    }
}
