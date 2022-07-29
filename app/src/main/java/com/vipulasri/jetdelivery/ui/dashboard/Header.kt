package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R

@Composable
fun showHeader(title: String, hasMore: Boolean) {
    Row(
        modifier = Modifier.padding(
            PaddingValues(
                top = 5.dp,
                start = dimensionResource(id = R.dimen.padding),
                end = dimensionResource(id = R.dimen.padding),
                bottom = 5.dp
            )
        )
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
        )
    }

    if (hasMore) {
        TextButton(onClick = {}) {
            Text(text = "View All")
        }
    }
}