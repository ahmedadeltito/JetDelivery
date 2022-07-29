package com.vipulasri.jetdelivery.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R

@Composable
fun showLoading() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun showError(message: String, onRetry: () -> Unit) {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = message,
            style = TextStyle(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRetry) {
            Text(stringResource(id = R.string.retry))
        }
    }
}

@Composable
fun showVerticalDivider() {
    Divider(
        modifier = Modifier.padding(
            PaddingValues(
                start = dimensionResource(id = R.dimen.padding),
                end = dimensionResource(id = R.dimen.padding)
            )
        ), color = Color.LightGray.copy(alpha = 0.2f)
    )
}

@Preview
@Composable
private fun showErrorPreview() {
    showError(
        message = "Error Message\nSomething went wrong!",
        onRetry = { }
    )
}
