package com.atorresveiga.playingwithtransitions.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsTheme

@Composable
fun WooColoredButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onPrimary
        ),
        shape = shape,
        content = content
    )
}

@Composable
fun WooColoredTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colors.secondary
        ),
        content = content
    )
}

@Composable
fun WooWhiteButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colors.onSecondary
        ),
        shape = shape,
        content = content
    )
}

@Preview
@Composable
fun WooColoredButtonPreview(@PreviewParameter(BooleanProvider::class) isDarkTheme: Boolean) {
    PlayingWithTransitionsTheme(darkTheme = isDarkTheme) {
        WooColoredButton(
            onClick = {}
        ) {
            Text("Sample Button")
        }
    }
}

@Preview
@Composable
fun WooWhiteButtonPreview(@PreviewParameter(BooleanProvider::class) isDarkTheme: Boolean) {
    PlayingWithTransitionsTheme(darkTheme = isDarkTheme) {
        WooColoredTextButton(
            onClick = {}
        ) {
            Text("Sample Button")
        }
    }
}

@Preview
@Composable
fun WooColoredTextButton(@PreviewParameter(BooleanProvider::class) isDarkTheme: Boolean) {
    PlayingWithTransitionsTheme(darkTheme = isDarkTheme) {
        WooColoredTextButton(
            onClick = {}
        ) {
            Text("Sample Button")
        }
    }
}