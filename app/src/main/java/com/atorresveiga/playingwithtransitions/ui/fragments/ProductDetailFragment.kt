package com.atorresveiga.playingwithtransitions.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.Repository
import com.atorresveiga.playingwithtransitions.ui.TRANSITION_DURATION
import com.atorresveiga.playingwithtransitions.ui.screens.ProductDetailScreen
import com.atorresveiga.playingwithtransitions.ui.screens.PrologueScreen
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface
import com.google.android.material.transition.MaterialContainerTransform

class ProductDetailFragment : Fragment() {

    val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = TRANSITION_DURATION.toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(ContextCompat.getColor(requireContext(), R.color.color_surface))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            ViewCompat.setTransitionName(this, getString(R.string.product_detail_transition_name))
            setContent {
                PlayingWithTransitionsThemeWithSurface {
                    ProductDetailScreen(
                        product = Repository.findProduct(args.productId),
                        onBackPressed = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}