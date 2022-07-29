package com.vipulasri.jetdelivery.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun AppTopBar(name: String, navigationIcon: @Composable (() -> Unit)? = null) {
    TopAppBar(
        title = { Text(text = name) },
        navigationIcon = navigationIcon
    )
}