package com.atorresveiga.playingwithtransitions

object Repository {
    val products = listOf (
        Product(
            id = 1,
            name = "Black Coral shades",
            price = "USD 150",
            inStock = true,
            image = "https://automatticwidgets.wpcomstaging.com/wp-content/uploads/2020/01/Mask-Group-1.png?w=201"
        ),
        Product(
            id = 2,
            name = "Malaya shades",
            price = "USD 140",
            inStock = true,
            image = "https://automatticwidgets.wpcomstaging.com/wp-content/uploads/2020/01/Mask-Group.png?w=201"
        ),
        Product(
            id = 3,
            name = "Rose Gold shades",
            price = "USD 120",
            inStock = false,
            image = "https://automatticwidgets.wpcomstaging.com/wp-content/uploads/2020/01/charles-1-nx1QR5dTE-unsplash.png?w=201"
        )
    )

    fun findProduct(id: Int) = products[id - 1]
}

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val inStock: Boolean,
    val image: String
)