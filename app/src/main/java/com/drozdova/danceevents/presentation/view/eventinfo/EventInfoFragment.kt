package com.drozdova.danceevents.presentation.view.eventinfo

import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.drozdova.danceevents.databinding.FragmentEventInfoBinding
import com.drozdova.danceevents.utils.BundleConstants
import com.squareup.picasso.Picasso

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
            val location = safeBundle.getString(BundleConstants.EVENT_LOCATION)
            val contacts = safeBundle.getString(BundleConstants.EVENT_CONTACTS)
            val description = safeBundle.getString(BundleConstants.EVENT_DESCRIPTION)
            val photo = safeBundle.getString(BundleConstants.EVENT_PHOTO)

            binding.tviEventTitle.text = title
            binding.tviEventDate.text = date
            binding.tviEventLocation.text = location
            binding.tviEventOrgContacts.text = contacts
            binding.tviEventDescription.text = Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT)
            Picasso.get().load(Uri.parse(photo)).into(binding.imviEventImage)
        }

        binding.tviEventDescription.movementMethod = ScrollingMovementMethod()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}