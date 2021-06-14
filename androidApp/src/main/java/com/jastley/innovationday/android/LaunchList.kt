package com.jastley.innovationday.android

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.jastley.innovationday.shared.entity.RocketLaunch

@Composable
fun LaunchList(launches: List<RocketLaunch>) {
    LazyColumn {
        items(launches, key = {
            it.missionName
        }) { launch ->
            LaunchCard(
                missionName = launch.missionName,
                launchSuccess = launch.launchSuccess,
                launchYear = launch.launchYear,
                details = launch.details
            )
        }

    }
}
