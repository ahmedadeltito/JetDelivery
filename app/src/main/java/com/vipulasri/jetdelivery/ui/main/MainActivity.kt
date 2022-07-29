package com.vipulasri.jetdelivery.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.AppTopBar
import com.vipulasri.jetdelivery.components.showError
import com.vipulasri.jetdelivery.components.showLoading
import com.vipulasri.jetdelivery.data.Repository
import com.vipulasri.jetdelivery.data.Result
import com.vipulasri.jetdelivery.ui.dashboard.showDashboard
import com.vipulasri.jetdelivery.ui.theme.JetDeliveryTheme

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            JetDeliveryTheme {
                Scaffold(topBar = {
                    AppTopBar(
                        name = stringResource(id = R.string.app_name),
                        navigationIcon = {
                            IconButton(onClick = {
                                viewModel.loadData(randomCalls = Repository.RandomCalls.values().random())
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = "Edit"
                                )
                            }
                        }
                    )
                }) {
                    when (val data = viewModel.dashboardItems.observeAsState().value) {
                        is Result.Loading -> {
                            showLoading()
                        }
                        is Result.Success -> {
                            showDashboard(
                                data = data.data ?: emptyList()
                            )
                        }
                        is Result.Failure -> {
                            showError(
                                message = data.error.message ?: "",
                                onRetry = {
                                    viewModel.loadData(randomCalls = Repository.RandomCalls.values().random())
                                })
                        }
                    }
                }
            }
            viewModel.loadData(randomCalls = Repository.RandomCalls.values().random())
        }
    }
}
