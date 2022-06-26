package com.atorresveiga.playingwithtransitions.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atorresveiga.playingwithtransitions.ui.composables.Action
import com.atorresveiga.playingwithtransitions.ui.composables.BackNavigationScaffold
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

@Composable
internal fun HelpSupportScreen(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackNavigationScaffold(
        topBarTitle = "Help & support",
        onBackPressed = onBackPressed
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface)
                    .verticalScroll(rememberScrollState())
            ) {
                val helpActionModifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 72.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

                Text(
                    text = "How can I help?",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(top = 16.dp, start = 72.dp)
                )
                Action(
                    title = "Help Center",
                    description = "Get answers to questions you have",
                    modifier = helpActionModifier
                )
                Divider()
                Action(
                    title = "Contact support",
                    description = "Reach our happiness engineers who can help answer tough questions",
                    modifier = helpActionModifier
                )
                Action(
                    title = "Contact Payments Support",
                    description = "Reach our happiness engineers who can help answer payment related questions",
                    modifier = helpActionModifier
                )
                Action(
                    title = "My tickets",
                    description = "View previously submitted tickets",
                    modifier = helpActionModifier
                )
                Action(
                    title = "Contact email",
                    description = "test@gmail.com",
                    modifier = helpActionModifier
                )
                Divider()
                Action(
                    title = "Application log",
                    description = "Advanced tool to review the app status",
                    modifier = helpActionModifier
                )
            }

            Text(
                text = "version 9.4.rc-1",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
internal fun HelpSupportScreenPreview() {
    PlayingWithTransitionsThemeWithSurface {
        HelpSupportScreen(
            onBackPressed = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HelpSupportScreenDarkPreview() {
    PlayingWithTransitionsThemeWithSurface(darkTheme = true) {
        HelpSupportScreen(
            onBackPressed = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}