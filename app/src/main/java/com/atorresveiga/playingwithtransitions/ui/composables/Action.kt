package com.atorresveiga.playingwithtransitions.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsTheme
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

@Composable
internal fun TextTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
        modifier = modifier
    )
}

@Composable
internal fun TextDescription(
    description: String,
    modifier: Modifier = Modifier
) {
    Text(text = description, modifier = modifier.alpha(0.8f))
}

@Composable
internal fun Action(
    title: String,
    description: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    leadingContent: @Composable RowScope.() -> Unit = {},
    trailingContent: @Composable RowScope.() -> Unit = {},
    onActionPressed: () -> Unit = {}
) {
    Row(modifier = Modifier
        .clickable { onActionPressed() }
        .then(modifier)
    ) {
        leadingContent()
        Column(modifier = Modifier.weight(1f)) {
            TextTitle(title = title)
            Spacer(modifier = Modifier.fillMaxWidth().height(4.dp))
            description()
        }
        trailingContent()
    }
}

@Composable
internal fun Action(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    leadingContent: @Composable RowScope.() -> Unit = {},
    trailingContent: @Composable RowScope.() -> Unit = {},
    onActionPressed: () -> Unit = {}
) {
    Action(
        title = title,
        description = { TextDescription(description = description) },
        modifier = modifier,
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        onActionPressed = onActionPressed
    )
}

@Preview(widthDp = 400, heightDp = 100)
@Composable
internal fun HelpActionPreview() {
    PlayingWithTransitionsThemeWithSurface {
        Action(
            title = "Help Center",
            description = "Get answers to questions you have"
        )
    }
}