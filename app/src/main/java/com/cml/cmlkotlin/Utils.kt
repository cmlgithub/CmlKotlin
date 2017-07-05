package com.cml.cmlkotlin

import android.content.Context
import android.widget.Toast

/**
 * author：cml on 2017/7/5
 * github：https://github.com/cmlgithub
 */
val ArrayList<String>.lastIndex : Int get() = size -1

fun Context.showToast(message: String?){
    Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
}
