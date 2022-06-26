package com.atorresveiga.playingwithtransitions.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.ui.composables.ProloguePager
import com.atorresveiga.playingwithtransitions.ui.composables.WooColoredButton
import com.atorresveiga.playingwithtransitions.ui.composables.WooWhiteButton
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface


@Composable
internal fun PrologueScreen(
    modifier: Modifier = Modifier,
    onStoreLogIn: () -> Unit = {},
    onWordpressLogIn: () -> Unit = {}
) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (logo, pager, buttonStore, buttonWordpress, background) = createRefs()
        Image(
            painter = painterResource(R.drawable.img_woo_logo),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 64.dp)
        )

        Image(
            painter = painterResource(R.drawable.img_prologue_bg),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(background) {
                    top.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                },
            contentScale = ContentScale.FillBounds
        )

        ProloguePager(modifier = Modifier.constrainAs(pager) {
            top.linkTo(logo.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(buttonStore.top)
            height = Dimension.fillToConstraints
        })

        WooColoredButton(
            onClick = { onStoreLogIn() },
            modifier = Modifier
                .constrainAs(buttonStore) {
                    bottom.linkTo(buttonWordpress.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text("Enter your store address")
        }
        WooWhiteButton(
            onClick = { onWordpressLogIn() },
            modifier = Modifier
                .constrainAs(buttonWordpress) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
        ) {
            Text("Continue with Wordpress.com")
        }
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
internal fun PrologueScreenPreview() {
    PlayingWithTransitionsThemeWithSurface {
        PrologueScreen()
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun PrologueScreenDarkPreview() {
    PlayingWithTransitionsThemeWithSurface(darkTheme = true) {
        PrologueScreen()
    }
}
