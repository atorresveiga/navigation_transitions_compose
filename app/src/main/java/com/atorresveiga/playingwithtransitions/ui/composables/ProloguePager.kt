package com.atorresveiga.playingwithtransitions.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsTheme
import com.atorresveiga.playingwithtransitions.ui.theme.prologueIndicator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

data class PrologueItemData(val imageResource: Int, val messageResource: Int)

private val prologueItems = listOf(
    PrologueItemData(
        imageResource = R.drawable.img_prologue_analytics,
        messageResource = R.string.prologue_analytics
    ),
    PrologueItemData(
        imageResource = R.drawable.img_prologue_orders,
        messageResource = R.string.prologue_orders
    ),
    PrologueItemData(
        imageResource = R.drawable.img_prologue_products,
        messageResource = R.string.prologue_products
    ),
    PrologueItemData(
        imageResource = R.drawable.img_prologue_reviews,
        messageResource = R.string.prologue_reviews
    )
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProloguePager(
    modifier: Modifier = Modifier,
    items: List<PrologueItemData> = prologueItems,
) {
    Column(modifier = modifier) {
        val pagerState = rememberPagerState()
        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) { page ->
            PrologueItem(items[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.prologueIndicator,
            inactiveColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 24.dp)
        )
    }
}

@Composable
internal fun PrologueItem(item: PrologueItemData, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = item.imageResource),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = item.messageResource),
            modifier = Modifier
                .width(240.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
internal fun PrologueItem() {
    PlayingWithTransitionsTheme {
        Surface {
            PrologueItem(prologueItems.first())
        }
    }
}