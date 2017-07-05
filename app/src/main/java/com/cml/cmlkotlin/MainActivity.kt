package com.cml.cmlkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    val TAG = "CML"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 省略findViewById的资源调用
         * 简洁开启Activity的方式
         * 省略xml布局方式-->NewActivity
         */
        textView.setOnClickListener {
//            var intent = Intent(this,NewActivity::class.java)//Kotlin 方式
//            intent.putExtra("userId",1001)
//            intent.putExtra("name","CML")
//            startActivity(intent)

            startActivity<NewActivity>("userId" to 1001,"name" to "CML") // Anko方式
        }


        /**
         * 基础类型
         *
         */
        var a0 = 2 //变量可以不指明类型Kotlin会自己判断;

        var a : Int = 2  //int 不能自己转换成Double需要自己转化;
        var b = a.toDouble()
//        var c = a as Double

        var d : Char = 'a'//Char不能直接等值于其对应的ASCII码值,需要类型转换;
        var e: Int = d.toInt()

        val f = 8  //val 定义常量相当于final

        var name : String //未初始化的变量必须指明类型,否则Kotlin无法自动判断其类型,编译器报错

        /**
         *   : 的用处
         *      被用于类型定义;
         *      被用于类继承和接口的实现;
         *      ::被用于对java类的调用
         */
        var str : String

        class MainActivity : AppCompatActivity() {}

        var intent = Intent(this,com.cml.cmlkotlin.MainActivity::class.java)

        /**
         * 类型检测 is == instanceOf
         */
        var message:String = ""
        var isString : Boolean = message is String

        /**
         * 字符串模板
         */
        var myName = "CML"
        var myAge = 25
        Log.e(TAG,"${myName}今年${myAge}岁")

        /**
         * 方法
         *
         */

        fun sum(a:Int ,b:Int):Int{
            return a+b
        }
        fun sum2(a:Int ,b:Int):Unit{
            Log.e(TAG,"$a+$b")
        }
        fun sum3(a:Int ,b:Int){ //返回值为Unit时可以省略
            Log.e(TAG,"${a+b}")
        }
        fun sum4(a:Int = 3 ,b:Int ){ //指定默认初始值
            Log.e(TAG,"${a+b}")
        }
        fun sum5(vararg aug1: String,strr : String){ //可变形参只能存在一个,但是其余的非可变形参赋值时需要指定参数名

        }
        sum2(1,1)
        sum3(2,2)
        sum4(b = 2)//调用有指定默认初始值的函数时,在只传没有值的参数情况下要指定参数名
        sum5("1","2",strr = "4")

        /**
         * 类与继承
         *      Kotlin 中所有的类都继承与Any
         *      默认所有的类都不可被继承,只有被open修饰的类才可
         */

        class Demo : Any() {}//类的定义和继承,默认无参的构造函数
        var demo = Demo() // 类的实例化

        class Demo2(name :String = "CML") {
            var mName: String = name
            init {
                Log.e(TAG,mName)
            }

            constructor(age:Int,name:String):this(name){
                Log.e(TAG,"year old:$age")
            }
        }

        var demo2 = Demo2(25,"MAKE")

        /**
         * 单例 : 使用object 来定义单例类
         * 伴随对象 : 使用 companion 修饰 object 来实现静态属性和方法
         */
        Shop.buySomething()
        Mall.buy()
        Mall.SHOP_NAME


        /**
         * if语句
         */

        fun maxNum(num1:Int,num2:Int):Int{//表达式形式
            return if(num1 > num2) num1 else num2
        }

        fun maxNumPlus(num1:Int,num2:Int):Int{//代码块形式
            var max = if(num1 > num2){
                print("num1 max")
                num1
            }else{
                print("num2 max")
                num2
            }
            return max
        }

        /**
         * when 语句  :替代了java中的switch-case
         */
        fun whenCase(obj : Any){
            when(obj){
                1 -> println("是数字1")
                -1, 0 -> println("是数字0或-1")
                in 1..10 -> println("是不大于10的正整数")
                "abc" -> println("是字符串abc")
                is Double -> println("类型是双精度浮点数")
                else -> println("其他操作")
            }
        }

        /**
         * 标签
         */

        fun tag(){
            aa@ for (i in 1..10){
                println(i)
                for (j in 1..10){
                    println(j)
                    if(j % 2 == 0){
                        break@aa
                    }
                }
            }
        }
        /**
         * for语句、while语句、continue语句和break语句等逻辑都与Java基本一致
         */

        /**
         * 空指针
         *      Kotlin 中默认类型都是非空的
         *      加上?代表这个变量可以为空
         */
//        var sss1 : String = null // 这里编译器报错
        var sss2 : String? = null //可以为null

//        var l1 = sss1.length //编译器可以正常通过
//        var l2 = sss2.length //编译器报错,因为没有做非空的判断
        if(null != sss2){
            var l2 = sss2.length //编译器可以正常通过
        }
        sss2?.length //Kotlin安全调用方式,当sss2 = null 时, sss2?.length也为null

        var length  = 0
        if(null != sss2){//java 方式
            length = sss2.length
        }else{
            length = -1
        }

        sss2?.length ?:-1//kotlin方式

//        sss2!!.length //会导致NullPointException

        /**
         * 扩展函数和扩展属性
         *      扩展需要再包级别范围内进行,在class内是无效的
         *      已经存在的方法和属性是无法被扩展的
         */
        showToast(null)//对Context增加了方法,可以在任何有context 的地方直接调用
        var list = ArrayList<String>()
        list.lastIndex //对ArrayList增加了属性,可以在任何有ArrayList的地方直接调用

        /**
         * 简洁数据类
         */
        fun dataTest(){
            var s = Student("CML",25,null)
            println("名称:${s.name},年龄:${s.age},爱好:${s.hobby},学校:${s.university}")

        }
        dataTest()
    }



    object Shop {
        fun buySomething() {
            println("Bought it")
        }
    }

    class Mall(name:String){
       companion object Shop{
           val SHOP_NAME = "SHOP"//相当于public static final
            fun buy(){
                print("pay")
            }
        }
    }

    /**
     * 点击监听
     * 非setOnClickListener方式
     * onClick方式
     */
    fun demo(view: View):Unit{
        startActivity<DemoListPageActivity>()
    }


}


