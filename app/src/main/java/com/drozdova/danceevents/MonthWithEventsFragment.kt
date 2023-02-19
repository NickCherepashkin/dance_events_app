package com.drozdova.danceevents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.drozdova.danceevents.databinding.FragmentMonthWithEventsBinding
import java.util.*

class MonthWithEventsFragment : Fragment() {
    private var _binding: FragmentMonthWithEventsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthWithEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance()
        calendar.set(
            2024,
            4,
            1
        )
        binding.cvMonth.date = calendar.timeInMillis
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}