package com.momen.cppproject.recycler_view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.momen.cppproject.Lessons.*
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.home_item.view.*

class adapter_home(val data : Array<String>) : RecyclerView.Adapter<adapter_home.ViewHolderIndex>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter_home.ViewHolderIndex {
        var layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.home_item , parent , false)
        return ViewHolderIndex(layoutInflater)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: adapter_home.ViewHolderIndex, position: Int) {
        val data = data[position]
        holder.bind(data , position)
    }
    class ViewHolderIndex(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : String , position: Int){
            itemView.txt_lesson.text = data
            itemView.setOnClickListener {
                when(position){
                    0-> itemView.context.startActivity(Intent(itemView.context , Introduction::class.java))
                    1-> itemView.context.startActivity(Intent(itemView.context , General_Structure::class.java))
                    2-> itemView.context.startActivity(Intent(itemView.context , Variables::class.java))
                    3-> itemView.context.startActivity(Intent(itemView.context , Iostream::class.java))
                    4-> itemView.context.startActivity(Intent(itemView.context , Cin::class.java))
                    5-> itemView.context.startActivity(Intent(itemView.context , ArthmeticLogical::class.java))
                    6-> itemView.context.startActivity(Intent(itemView.context , Logical::class.java))
                    7-> itemView.context.startActivity(Intent(itemView.context , MathmaticOperations::class.java))
                    8-> itemView.context.startActivity(Intent(itemView.context , ifStatment::class.java))
                    9-> itemView.context.startActivity(Intent(itemView.context , Switch::class.java))
                    10-> itemView.context.startActivity(Intent(itemView.context , Loops::class.java))
                    11-> itemView.context.startActivity(Intent(itemView.context , While::class.java))
                    12-> itemView.context.startActivity(Intent(itemView.context , DoWhile::class.java))
                    13-> itemView.context.startActivity(Intent(itemView.context , Arrays::class.java))
                    14-> itemView.context.startActivity(Intent(itemView.context , Array2d::class.java))
                    15-> itemView.context.startActivity(Intent(itemView.context , Functions::class.java))
                    16-> itemView.context.startActivity(Intent(itemView.context , Structures::class.java))
                    17-> itemView.context.startActivity(Intent(itemView.context , Oop::class.java))
                    18-> itemView.context.startActivity(Intent(itemView.context , Classes::class.java))
                    19-> itemView.context.startActivity(Intent(itemView.context , Inheritance::class.java))
                    20-> itemView.context.startActivity(Intent(itemView.context , Access::class.java))
                    21-> itemView.context.startActivity(Intent(itemView.context , Encapsulation::class.java))
                    22-> itemView.context.startActivity(Intent(itemView.context , Polymorphism::class.java))
                }


            }
        }
    }
}
