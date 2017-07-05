package com.cml.cmlkotlin

import android.util.Log
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * author：cml on 2017/7/5
 * github：https://github.com/cmlgithub
 */
class LoginAnkoUI :AnkoComponent<NewActivity>{
    override fun createView(ui: AnkoContext<NewActivity>): View {
        return with(ui){
            verticalLayout{
                var textView = textView("用户名"){
                    textSize = sp(15).toFloat()
                    textColor = R.color.colorPrimary
                }.lparams{
                    margin = dip(10)
                    height = dip(50)
                }
                val username = editText("输入...")
                button("登录"){
                    onClick { Log.e("CML",username.text.toString()) }
                }
            }
        }
    }
}