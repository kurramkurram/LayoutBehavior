package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var mBottomSheet: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        val bottomSheet = findViewById<LinearLayout>(R.id.bottom_sheet_layout)
        mBottomSheet = BottomSheetBehavior.from(bottomSheet)

        mBottomSheet.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.d("MainActivity", "#onCreate\$onStateChanged state = $newState")
            }

        })
        textView.setOnClickListener { onTextClicked(it) }
    }

    private fun onTextClicked(view: View) {
        when (view.id) {
            R.id.text_view ->
                if (mBottomSheet.state != BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    mBottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
                }
        }
    }
}
