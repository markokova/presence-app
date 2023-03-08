package com.marko112.lecturepresenceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectRecyclerAdapter(
    private val items: ArrayList<Subject>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SubjectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.subject_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is SubjectViewHolder ->{
                holder.bind(position, items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class SubjectViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private val subjectName: TextView = view.findViewById<TextView>(R.id.recycler_item_subject_name)

        fun bind(index: Int, subject: Subject){
            subjectName.text = subject.name
        }
    }
}