package com.atorresveiga.playingwithtransitions.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.ui.screens.PrologueScreen
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

class PrologueFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                PlayingWithTransitionsThemeWithSurface {
                    PrologueScreen(
                        onStoreLogIn = { navController.navigate(R.id.action_store_login) }
                    )
                }
            }
        }
    }
}