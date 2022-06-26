package com.atorresveiga.playingwithtransitions.ui.composables

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class BooleanProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(true, false)
}