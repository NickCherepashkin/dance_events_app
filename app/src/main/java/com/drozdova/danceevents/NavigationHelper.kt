package com.drozdova.danceevents

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

object NavigationHelper {
    fun Fragment.navigate(destinationId: Int) {
        findNavController().navigate(destinationId)
    }

    fun Fragment.replaceGraph(graphId: Int) {
        findNavController().setGraph(graphId)
    }

    fun Fragment.navigateWithoutBackStack(destinationId: Int, fragmentRemove: Int) {
        val navOptions = NavOptions.Builder()
        navOptions.setPopUpTo(fragmentRemove, true)
        findNavController().navigate(destinationId, null, navOptions.build())
    }
}