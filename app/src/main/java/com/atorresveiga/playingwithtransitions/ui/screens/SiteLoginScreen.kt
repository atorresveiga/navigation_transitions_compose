package com.atorresveiga.playingwithtransitions.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.atorresveiga.playingwithtransitions.ui.composables.BackNavigationScaffold
import com.atorresveiga.playingwithtransitions.ui.composables.WooColoredButton
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

@Composable
internal fun SiteLoginScreen(
    onBackPressed: () -> Unit,
    onHelpPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackNavigationScaffold(
        topBarActions = {
            IconButton(onClick = onHelpPressed) {
                Icon(
                    imageVector = Icons.Filled.HelpOutline,
                    contentDescription = "Help",
                    tint = MaterialTheme.colors.onSurface
                )
            }
        },
        topBarTitle = "Log in",
        topBarElevation = 0.dp,
        onBackPressed = onBackPressed,
        content = { padding ->
            ConstraintLayout(
                modifier = modifier.fillMaxSize()
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = padding.calculateBottomPadding()
                    )
            ) {

                val (description, textField, label, button) = createRefs()

                Text(
                    text = "Enter the address of the WooCommerce store you'd like to connect",
                    modifier = Modifier.constrainAs(description) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                )

                var text by rememberSaveable { mutableStateOf("") }
                val focusRequester = remember { FocusRequester() }

                OutlinedTextField(
                    value = text,
                    modifier = Modifier
                        .constrainAs(textField) {
                            top.linkTo(description.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    onValueChange = { text = it },
                    label = { Text("Site address") },
                    singleLine = true
                )

                TextButton(
                    onClick = { },
                    modifier = Modifier
                        .constrainAs(label) {
                            top.linkTo(textField.bottom)
                            start.linkTo(parent.start)
                        }
                        .offset(
                            x = (-8).dp
                        )
                ) {
                    Text(
                        text = "Find your site address",
                        color = MaterialTheme.colors.secondary
                    )
                }

                WooColoredButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .constrainAs(button) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            width = Dimension.fillToConstraints
                        }
                ) {
                    Text("Continue")
                }

                LaunchedEffect(Unit) {
                   // focusRequester.requestFocus()
                }
            }
        }
    )
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
internal fun SiteLoginScreenPreview() {
    PlayingWithTransitionsThemeWithSurface {
        SiteLoginScreen(
            onBackPressed = {},
            onHelpPressed = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun SiteLoginScreenPreviewDarkPreview() {
    PlayingWithTransitionsThemeWithSurface(darkTheme = true) {
        SiteLoginScreen(
            onBackPressed = {},
            onHelpPressed = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}