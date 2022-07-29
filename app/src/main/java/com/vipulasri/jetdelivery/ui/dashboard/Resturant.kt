package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.network.model.Dashboard

@Composable
fun showRestaurantElement(item: Dashboard.Item.SubItem) {

    Row(modifier = Modifier.fillMaxHeight().padding(dimensionResource(id = R.dimen.padding))) {
        restaurantImage(url = item.imageUrl)
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    PaddingValues(
                        start = dimensionResource(id = R.dimen.padding),
                        end = dimensionResource(id = R.dimen.padding)
                    )
                )
        ) {
            restaurantInfo(item = item)
        }
    }
}

@Composable
private fun restaurantImage(url: String) {
    Box(Modifier.size(70.dp).clip(shape = RoundedCornerShape(5.dp))) {
        AsyncImage(url, contentDescription = null)
    }
}

@Composable
private fun restaurantInfo(item: Dashboard.Item.SubItem) {
    val title = item.title ?: "Name"
    val subTitle = item.subTitle ?: "Caption"
    val rating = "${item.meta?.rating}"
    val reviewCount = "${item.meta?.reviewCount}"

    Text(text = title)
    Text(text = subTitle)
    Text(text = rating)
    Text(text = " ( $reviewCount reviews)")
}
