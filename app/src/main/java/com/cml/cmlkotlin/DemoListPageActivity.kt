package com.cml.cmlkotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_demo_list_page.*
import kotlinx.android.synthetic.main.item.view.*

class DemoListPageActivity : AppCompatActivity() {
    var list = ArrayList<Student>()
    var listAdapter = ListAdapter(this,list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_list_page)

        (1..20).mapTo(list) { Student("cml$it", it,null) }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = listAdapter

    }

    class ListAdapter(var context: Context,var list : ArrayList<Student>) : RecyclerView.Adapter<ListViewHolder>() {
        override fun getItemCount(): Int {
            return list.size
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder {
            return ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
        }

        override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
            holder?.bind(list[position])
        }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(stu : Student) = with(itemView){
            name.text = stu.name
            age.text = "${stu.age}"
            setOnClickListener { Log.e("CML","DAFD")}
        }
    }

    fun clear(view:View){
        list.clear()
        listAdapter.notifyDataSetChanged()
        noNata.visibility = View.VISIBLE
    }
    fun add(view:View){
        noNata.visibility = View.GONE
        (21..30).mapTo(list) { Student("cml$it", it,null) }
        listAdapter.notifyDataSetChanged()
    }
}
