package com.jastley.innovationday.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jastley.innovationday.shared.SpaceXSDK
import com.jastley.innovationday.shared.cache.DatabaseDriverFactory
import com.jastley.innovationday.shared.entity.RocketLaunch


class MainActivity : ComponentActivity() {

    private val sdk = SpaceXSDK(DatabaseDriverFactory(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LaunchViewModel by viewModels { LaunchViewModelFactory(this, sdk)}

        setContent {
            AppTheme {
                Launches(viewModel = viewModel)
            }
        }
    }

}

@Composable
fun Launches(viewModel: LaunchViewModel) {
    val launches: List<RocketLaunch> by viewModel.launchList.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("SpaceX Launches") }) },
    ) {
        LaunchList(launches = launches)
    }
}

