package com.atorresveiga.playingwithtransitions.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.atorresveiga.playingwithtransitions.R

@Composable
fun BackNavigationScaffold(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    topBarActions: @Composable RowScope.() -> Unit = {},
    topBarElevation: Dp = AppBarDefaults.TopAppBarElevation,
    topBarTitle: String = stringResource(R.string.default_title),
    content: @Composable (paddingValues: PaddingValues) -> Unit = {}
) {
    val topBar = @Composable {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            title = { Text(topBarTitle) },
            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            },
            actions = topBarActions,
            elevation = topBarElevation
        )
    }
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        content = content
    )
}