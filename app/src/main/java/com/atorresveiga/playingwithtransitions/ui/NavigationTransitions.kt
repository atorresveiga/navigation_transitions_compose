package com.atorresveiga.playingwithtransitions.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

const val TRANSITION_DURATION = 4400

@OptIn(ExperimentalAnimationApi::class)
val AnimatedContentScope<NavBackStackEntry>.materialSlideInRightTransition: EnterTransition
    get() = slideIntoContainer(
        towards = AnimatedContentScope.SlideDirection.Right,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        initialAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val AnimatedContentScope<NavBackStackEntry>.materialSlideInLeftTransition: EnterTransition
    get() = slideIntoContainer(
        towards = AnimatedContentScope.SlideDirection.Left,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        initialAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val AnimatedContentScope<NavBackStackEntry>.materialSlideOutLeftTransition: ExitTransition
    get() = slideOutOfContainer(
        towards = AnimatedContentScope.SlideDirection.Left,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeOut(
        targetAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val AnimatedContentScope<NavBackStackEntry>.materialSlideOutRightTransition: ExitTransition
    get() = slideOutOfContainer(
        towards = AnimatedContentScope.SlideDirection.Right,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeOut(
        targetAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val materialScaleInTransitionOut: EnterTransition
    get() = scaleIn(
        initialScale = 0.9f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        initialAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val materialScaleOutTransitionOut: ExitTransition
    get() = scaleOut(
        targetScale = 1.15f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeOut(
        targetAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION / 3,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val materialScaleInTransitionIn: EnterTransition
    get() = scaleIn(
        initialScale = 1.15f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        initialAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = LinearEasing
        )
    )

@OptIn(ExperimentalAnimationApi::class)
val materialScaleOutTransitionIn: ExitTransition
    get() = scaleOut(
        targetScale = 0.9f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeOut(
        targetAlpha = 0f,
        animationSpec = tween(
            durationMillis = TRANSITION_DURATION / 3,
            easing = LinearEasing
        )
    )
