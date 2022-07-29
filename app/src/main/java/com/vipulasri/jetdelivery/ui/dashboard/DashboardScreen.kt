package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.showVerticalDivider
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.network.model.ItemViewType
import com.vipulasri.jetdelivery.network.model.SubItemViewType

@Composable
fun showDashboard(data: List<Dashboard.Item>) {
    LazyColumn(modifier = Modifier.padding(
        PaddingValues(
            top = dimensionResource(id = R.dimen.padding),
            bottom = dimensionResource(id = R.dimen.padding)
        )
    ).fillMaxHeight()) {
        items(items = data, itemContent = { item ->
            item.header?.let {
                showHeader(title = it.title, hasMore = it.hasMore)
            }
            when (item.viewType) {
                ItemViewType.HorizontalScroll -> showHorizontalElements(item = item)
                ItemViewType.VerticalScroll -> showVerticalElements(item = item)
            }
        })
    }
}

@Composable
private fun showHorizontalElements(item: Dashboard.Item) {
    LazyRow(modifier = Modifier.padding(
        PaddingValues(
            start = dimensionResource(id = R.dimen.padding),
            end = dimensionResource(id = R.dimen.padding)
        )
    ).fillMaxWidth()) {
        itemsIndexed(items = item.data) { index, oneItem ->
            if (index != item.data.size)
                Spacer(modifier = Modifier.width(10.dp))
            when (oneItem.viewType) {
                SubItemViewType.Banner -> showBannerElement(item = oneItem)
                SubItemViewType.Category -> showCategoryElement(item = oneItem)
                else -> {
                    // do nothing
                }
            }
        }
    }
}

@Composable
private fun showVerticalElements(item: Dashboard.Item) {
    item.data.forEachIndexed { index, data ->
        if (index != item.data.size)
            Spacer(modifier = Modifier.width(10.dp))
        when (data.viewType) {
            SubItemViewType.Restaurant -> showRestaurantElement(item = data)
            else -> {
                // do nothing
            }
        }
        if (index != item.data.size) showVerticalDivider()
    }
}
