package com.example.nestedscrollwithtabs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedscrollwithtabs.R
import com.example.nestedscrollwithtabs.model.TabItem
import kotlinx.android.synthetic.main.tab_row.view.*

class TabAdapter(private val context: Context, private val mList: ArrayList<TabItem>, private val listener: TabItemListener) :
    RecyclerView.Adapter<TabAdapter.TabAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TabAdapterViewHolder {
        return TabAdapterViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.tab_row,
                parent,
                false
            )
        )
    }
    
    override fun getItemCount(): Int {
        return mList.size
    }
    
    override fun onBindViewHolder(holder: TabAdapterViewHolder, position: Int) {
        val item = mList[position]

        holder.itemView.tv_tab.text = item.title

        if (item.isSelected) {
            holder.itemView.view.setBackgroundColor(context.resources.getColor(R.color.colorPrimary, null))
            holder.itemView.tv_tab.setTextColor(context.resources.getColor(R.color.colorPrimary, null))
        } else {
            holder.itemView.view.setBackgroundColor(context.resources.getColor(android.R.color.white, null))
            holder.itemView.tv_tab.setTextColor(context.resources.getColor(android.R.color.darker_gray, null))
        }

        holder.itemView.setOnClickListener {
            listener.onTabItemClick(position, item)
        }
    }
    
    class TabAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface TabItemListener {
        fun onTabItemClick(position: Int, tabItem: TabItem)
    }
}