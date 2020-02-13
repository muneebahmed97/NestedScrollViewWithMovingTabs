package com.example.nestedscrollwithtabs.scrollactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.nestedscrollwithtabs.R

class ScrollActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_scroll)
        for (i in 0..10) {
            val frameLayout = FrameLayout(this)
        }
    }
}
