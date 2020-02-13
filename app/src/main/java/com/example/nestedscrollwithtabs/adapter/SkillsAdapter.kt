package com.example.nestedscrollwithtabs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedscrollwithtabs.R

class SkillsAdapter(private val context: Context) :
    RecyclerView.Adapter<SkillsAdapter.SkillsAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SkillsAdapterViewHolder {
        return SkillsAdapterViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.skills_row,
                parent,
                false
            )
        )
    }
    
    override fun getItemCount(): Int {
        return 15
    }
    
    override fun onBindViewHolder(holder: SkillsAdapterViewHolder, position: Int) {
    }
    
    class SkillsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}