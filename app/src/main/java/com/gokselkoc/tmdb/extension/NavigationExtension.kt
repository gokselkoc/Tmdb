package com.gokselkoc.tmdb.extension

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.IdRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

fun Fragment.navigateSafe(
    @IdRes resId: Int,
    bundle: Bundle? = null,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null,
) {
    try {
        findNavController().navigate(
            resId,
            bundle,
            navOptions,
            navigatorExtras
        )
    } catch (exp: Exception) {
        Log.e("Navigation Error", exp.toString())
    }
}

fun Fragment.navigateToDirection(navDirections: NavDirections, view : ViewDataBinding){

    Navigation.findNavController(view.root).apply {
        currentDestination?.getAction(navDirections.actionId).run {
            navigate(navDirections.actionId,navDirections.arguments)
        }
    }

}
