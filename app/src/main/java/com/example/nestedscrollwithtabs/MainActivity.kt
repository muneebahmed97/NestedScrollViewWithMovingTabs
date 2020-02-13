package com.example.nestedscrollwithtabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedscrollwithtabs.adapter.ExperienceAdapter
import com.example.nestedscrollwithtabs.adapter.SkillsAdapter
import com.example.nestedscrollwithtabs.adapter.TabAdapter
import com.example.nestedscrollwithtabs.model.TabItem
import com.example.nestedscrollwithtabs.ui.NestedScrollingView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TabAdapter.TabItemListener,
    NestedScrollingView.NestedScrollViewScrollStateListener {

    private var isUserClicking = false
    private lateinit var tabAdapter: TabAdapter
    private val mList: ArrayList<TabItem> = ArrayList()
    private lateinit var horizontalLayout: LinearLayoutManager

    override fun onNestedScrollViewStateChanged(state: Int) {
    }

    override fun onNestedScrollViewFling(velocity: Int) {
        isUserClicking = false
    }

    override fun onTabItemClick(position: Int, tabItem: TabItem) {
        isUserClicking = true
        deselectAll(position)
        when (position) {
            0 -> nested_scroll_view.smoothScrollTo(0, overview_cont.top)
            1 -> nested_scroll_view.smoothScrollTo(0, skills_cont.top)
            2 -> nested_scroll_view.smoothScrollTo(0, description_cont.top)
            3 -> nested_scroll_view.smoothScrollTo(0, experience_cont.top)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun tabList() {
        mList.add(TabItem(true, "Overview"))
        mList.add(TabItem(false, "Skills"))
        mList.add(TabItem(false, "Description"))
        mList.add(TabItem(false, "Experience"))
    }

    private fun initViews() {
        tabList()
        tabAdapter = TabAdapter(this@MainActivity, mList, this@MainActivity)
        horizontalLayout = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

        rv_tabs.apply {
            layoutManager = horizontalLayout
            adapter = tabAdapter
        }

        rv_skills.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = SkillsAdapter(this@MainActivity)
        }

        rv_experience.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ExperienceAdapter(this@MainActivity)
        }

        initListeners()
    }
    

    private fun initListeners() {
        nested_scroll_view.setScrollListener(this)

        nested_scroll_view.setOnScrollChangeListener { _, _, newScrollY, _, oldScrollY ->

            val overviewTop = overview_cont.top
            val overviewBottom = overview_cont.bottom

            val skillsTop = skills_cont.top
            val skillsBottom = skills_cont.bottom

            val descriptionTop = description_cont.top
            val descriptionBottom = description_cont.bottom

            val experienceTop = experience_cont.top
            val experienceBottom = experience_cont.bottom

            if (isUserClicking) {
                return@setOnScrollChangeListener
            } else {
                when {
                    ((newScrollY >= overviewTop) && (oldScrollY < overviewBottom)) -> {
                        deselectAll(0)
                    }
                    ((newScrollY >= skillsTop) && (oldScrollY < skillsBottom)) -> {
                        deselectAll(1)
                    }
                    ((newScrollY >= descriptionTop) && (oldScrollY < descriptionBottom)) -> {
                        deselectAll(2)
                    }
                    ((newScrollY >= experienceTop) && (oldScrollY < experienceBottom)) -> {
                        deselectAll(3)
                    }
                }
            }
        }
    }

    private fun deselectAll(position: Int) {
        for (i in mList.indices) {
            if (mList[i].isSelected)
                mList[i].isSelected = false
        }

        mList[position].isSelected = true
        tabAdapter.notifyDataSetChanged()

        horizontalLayout.smoothScrollToPosition(rv_tabs, null, position)
    }
}
