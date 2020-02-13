package com.example.nestedscrollwithtabs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedscrollwithtabs.R

class ExperienceAdapter(val context: Context) :
    RecyclerView.Adapter<ExperienceAdapter.ExperienceAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExperienceAdapterViewHolder {
        return ExperienceAdapterViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.experience_row,
                parent,
                false
            )
        )
    }
    
    override fun getItemCount(): Int {
        return 15
    }
    
    override fun onBindViewHolder(holder: ExperienceAdapterViewHolder, position: Int) {
    }
    
    class ExperienceAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}