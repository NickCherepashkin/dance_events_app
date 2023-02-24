package com.drozdova.danceevents.presentation.view.eventinfo

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.drozdova.danceevents.databinding.FragmentEventInfoBinding
import com.drozdova.danceevents.utils.BundleConstants

class EventInfoFragment : Fragment() {
    private var _binding: FragmentEventInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val title = safeBundle.getString(BundleConstants.EVENT_TITLE)
            val date = "${safeBundle.getString(BundleConstants.EVENT_DATE_START)} - ${safeBundle.getString(BundleConstants.EVENT_DATE_END)}"
            val description = safeBundle.getString(BundleConstants.EVENT_DESCRIPTION)

            binding.tviEventTitle.text = title
            binding.tviEventDate.text = date
            binding.tviEventDescription.text = description
        }

        binding.tviEventDescription.movementMethod = ScrollingMovementMethod()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}