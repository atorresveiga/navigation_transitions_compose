package com.atorresveiga.playingwithtransitions.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.atorresveiga.playingwithtransitions.Repository
import com.atorresveiga.playingwithtransitions.ui.screens.HelpSupportScreen
import com.atorresveiga.playingwithtransitions.ui.screens.ProductDetailScreen
import com.atorresveiga.playingwithtransitions.ui.screens.PrologueScreen
import com.atorresveiga.playingwithtransitions.ui.screens.SiteLoginScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

object AuthDestinations {
    const val PrologueRoute = "prologue"
    const val SiteLoginRoute = "site_login"
    const val HelpSupportRoute = "help_support"
    const val ProductDetailRoute = "product_detail"
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(startDestination: String = AuthDestinations.PrologueRoute) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController, startDestination = startDestination) {
        composable(route = AuthDestinations.ProductDetailRoute){
            ProductDetailScreen(product = Repository.products.first(), onBackPressed = { })
        }
        composable(route = AuthDestinations.PrologueRoute,
            enterTransition = {
                when (initialState.destination.route) {
                    AuthDestinations.SiteLoginRoute -> materialSlideInRightTransition
                    else -> null
                }
            }, exitTransition = {
                when (targetState.destination.route) {
                    AuthDestinations.SiteLoginRoute -> materialSlideOutLeftTransition
                    else -> null
                }
            }) {
            PrologueScreen(
                onStoreLogIn = { navController.navigate(AuthDestinations.SiteLoginRoute) }
            )
        }
        composable(route = AuthDestinations.SiteLoginRoute,
            enterTransition = {
                when (initialState.destination.route) {
                    AuthDestinations.PrologueRoute -> materialSlideInLeftTransition
                    AuthDestinations.HelpSupportRoute -> materialScaleInTransitionIn
                    else -> null
                }
            }, popExitTransition = {
                when (targetState.destination.route) {
                    AuthDestinations.PrologueRoute -> materialSlideOutRightTransition
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    AuthDestinations.HelpSupportRoute -> materialScaleOutTransitionOut
                    else -> null
                }
            }

        ) {
            SiteLoginScreen(
                onBackPressed = { navController.popBackStack() },
                onHelpPressed = { navController.navigate(AuthDestinations.HelpSupportRoute) }
            )
        }
        composable(
            route = AuthDestinations.HelpSupportRoute,
            enterTransition = {
                when (initialState.destination.route) {
                    AuthDestinations.SiteLoginRoute -> materialScaleInTransitionOut
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    AuthDestinations.SiteLoginRoute -> materialScaleOutTransitionIn
                    else -> null
                }
            }
        ) {
            HelpSupportScreen(
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}