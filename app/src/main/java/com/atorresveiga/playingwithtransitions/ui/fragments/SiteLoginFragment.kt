package com.atorresveiga.playingwithtransitions.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atorresveiga.playingwithtransitions.ui.screens.SiteLoginScreen
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

class SiteLoginFragment  : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                PlayingWithTransitionsThemeWithSurface {
                    SiteLoginScreen(
                        onBackPressed = { navController.popBackStack() },
                        onHelpPressed = {}
                    )
                }
            }
        }
    }
}