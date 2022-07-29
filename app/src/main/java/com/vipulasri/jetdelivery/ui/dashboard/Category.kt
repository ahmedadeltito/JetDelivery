package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.vipulasri.jetdelivery.network.model.Dashboard

@Composable
fun showCategoryElement(item: Dashboard.Item.SubItem) {
    Column {
        categoryImage(item = item)
        categoryInfo(
            title = item.title,
            subTitle = item.subTitle
        )
    }
}

@Composable
private fun categoryImage(item: Dashboard.Item.SubItem) {
    AsyncImage(item.imageUrl, contentDescription = null)
}

@Composable
private fun categoryInfo(title: String?, subTitle: String?) {
    title?.let {
        Text(text = it)
    }
    subTitle?.let {
        Text(text = it)
    }
}