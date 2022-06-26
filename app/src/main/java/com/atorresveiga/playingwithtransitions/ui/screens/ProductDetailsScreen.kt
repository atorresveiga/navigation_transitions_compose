package com.atorresveiga.playingwithtransitions.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.atorresveiga.playingwithtransitions.Product
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.Repository
import com.atorresveiga.playingwithtransitions.ui.composables.Action
import com.atorresveiga.playingwithtransitions.ui.composables.BackNavigationScaffold
import com.atorresveiga.playingwithtransitions.ui.composables.TextDescription
import com.atorresveiga.playingwithtransitions.ui.theme.PlayingWithTransitionsThemeWithSurface

@Composable
internal fun ProductDetailScreen(
    product: Product, onBackPressed: () -> Unit, modifier: Modifier = Modifier
) {
    BackNavigationScaffold(
        onBackPressed = onBackPressed, topBarTitle = product.name
    ) {
        Box( modifier = modifier.fillMaxSize()) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                MainProductCard(product = product)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
                SecondaryProductCard(product = product)
            }
            AddMoreDetailsCard(Modifier.align(Alignment.BottomStart))
        }
    }
}

@Composable
internal fun MainProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(elevation = 4.dp) {
        Column(modifier = modifier.fillMaxWidth()) {
            ProductImages(
                product = product,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            Divider()
            var productName by rememberSaveable { mutableStateOf(product.name) }
            TextField(
                value = productName,
                onValueChange = { productName = it },
                textStyle = MaterialTheme.typography.h6,
                colors = TextFieldDefaults
                    .textFieldColors(backgroundColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth()

            )
            Action(
                title = "Description",
                description = "product description very long text",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                trailingContent = {
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(12.dp)
                    )
                }
            )
        }

    }
}

@Composable
internal fun SecondaryProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(elevation = 4.dp) {
        Column(modifier = modifier.fillMaxWidth()) {
            Action(
                title = "Price",
                description = product.price,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.LocalAtm,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 24.dp)
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(12.dp)
                    )
                }
            )
            Divider()
            Action(
                title = "Reviews",
                description = "No approved reviews",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.StarOutline,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 24.dp)
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(12.dp)
                    )
                }
            )
            Divider()
            Action(
                title = "Inventory",
                description = {
                    Column {
                        TextDescription(description = "SKU:30")
                        TextDescription(description = "Stock status: In Stock")
                    }
                },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.Checklist,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 24.dp)
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(12.dp)
                    )
                }
            )

        }
    }
}

@Composable
internal fun ProductImages(
    product: Product,
    modifier: Modifier = Modifier
) {
    val itemModifier = Modifier
        .padding(start = 16.dp)
        .clickable { }
        .size(120.dp)
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f)
        )

    LazyRow(modifier = modifier) {
        item {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_product),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = itemModifier
            )
        }
        item {
            Box(modifier = itemModifier) {
                Icon(
                    imageVector = Icons.Filled.AddAPhoto,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
internal fun AddMoreDetailsCard(modifier: Modifier = Modifier) {
    Card(elevation = 8.dp, modifier = modifier
        .fillMaxWidth()
        .clickable { }) {
        Row(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = MaterialTheme.colors.secondary
            )
            Text(
                text = "Add more details".uppercase(),
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
internal fun ProductDetailScreenPreview() {
    PlayingWithTransitionsThemeWithSurface {
        ProductDetailScreen(
            onBackPressed = {}, product = Repository.products.first()
        )
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun ProductDetailScreenDarkPreview() {
    PlayingWithTransitionsThemeWithSurface(darkTheme = true) {
        ProductDetailScreen(
            onBackPressed = {}, product = Repository.products.first()
        )
    }
}