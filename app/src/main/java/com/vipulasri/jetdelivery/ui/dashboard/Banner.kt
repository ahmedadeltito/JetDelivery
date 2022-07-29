package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vipulasri.jetdelivery.network.model.Dashboard

@Composable
fun showBannerElement(item: Dashboard.Item.SubItem) {
    Column(
        modifier = Modifier.size(140.dp).clip(shape = RoundedCornerShape(5.dp))
    ) {
        bannerImage(url = item.imageUrl)
        item.title?.let {
            bannerText(title = it)
        }
    }
}

@Composable
private fun bannerImage(url: String) {
    AsyncImage(modifier = Modifier.size(80.dp), model = url, contentDescription = null)
}

@Composable
private fun bannerText(title: String) {
    Text(
        modifier = Modifier.fillMaxWidth().padding(PaddingValues(10.dp)),
        text = title,
    )
}