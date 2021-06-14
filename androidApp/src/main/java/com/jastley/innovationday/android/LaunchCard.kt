package com.jastley.innovationday.android

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LaunchCard(
    missionName: String = "Mission Name", launchSuccess: Boolean? = true,
    launchYear: Int = 2021,
    details: String? = "Some details string",
) {
    val launchColor: Color = launchSuccess?.let {
        if (launchSuccess) Color.Green else Color.Red
    } ?: Color.Gray


    Card(
        elevation = 4.dp,
        border = BorderStroke(width = 2.dp, launchColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(Modifier.padding(all = 8.dp)) {
            Text(text = "Launch name: $missionName")
            launchSuccess?.let {
                Text(
                    text = if (launchSuccess) "Successful" else "Unsuccessful",
                    color = launchColor
                )
            }
            Text(text = "Launched: $launchYear")
            details?.let {
                Text(
                    text = it, fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}
