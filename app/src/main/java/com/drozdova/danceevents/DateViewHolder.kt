package com.drozdova.danceevents

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textview.MaterialTextView

class DateViewHolder(
    private val view: View
) : ViewHolder(view) {

    fun bind(days: Int, pos: Int, Y: Int, spaces: Int) {
        val tvDate = view.findViewById<MaterialTextView>(R.id.tv_date)
        val value: Int
        if(pos == spaces){
            value = 1
            tvDate.text = "${value}"
        } else if (pos > spaces) {
            value = 1 + (pos - spaces)
            tvDate.text = "${value}"
        } else {
            tvDate.text = ""
        }

//        if(Calendar.currentMonth==month){
//            if(value==Calendar.currentDate){
//                tvDate.setTextColor(view.getResources().getColor(R.color.teal_200)); // Current Date
//            }else if(date_value>Globals.currentDate){
//                holder.date_tv.setTextColor(context.getResources().getColor(R.color.black)); // Upcoming Date
//            }else{
//                holder.date_tv.setTextColor(context.getResources().getColor(R.color.disable_color)); // Past Date
//            }
//        }else if(month>Globals.currentMonth){
//            holder.date_tv.setTextColor(context.getResources().getColor(R.color.black));
//        }else{
//            holder.date_tv.setTextColor(context.getResources().getColor(R.color.disable_color));
//        }
//
//        if(Globals.selected_date.contains(checkMap)){
//            holder.date_tv.setBackgroundColor(context.getResources().getColor(R.color.purple_500));
//        }else{
//            holder.date_tv.setBackgroundColor(context.getResources().getColor(R.color.white));
//        }
    }
}