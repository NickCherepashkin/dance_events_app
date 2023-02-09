package com.drozdova.danceevents

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textview.MaterialTextView

class MonthViewHolder (private val view: View) : ViewHolder(view) {
    fun bind(month: String, days: Int, pos: Int, Y: Int, spaces: Int) {
        val rvDate = view.findViewById<RecyclerView>(R.id.rv_date)
        val tvMonth = view.findViewById<MaterialTextView>(R.id.tv_month)

        tvMonth.text = month
        rvDate.setHasFixedSize(true)
        rvDate.isNestedScrollingEnabled = true
        val dateAdapter = DateAdapter()
        rvDate.adapter = dateAdapter
        dateAdapter.submit(days, pos, Y, spaces)
    }
}