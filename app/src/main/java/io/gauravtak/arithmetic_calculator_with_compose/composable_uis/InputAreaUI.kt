package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.gauravtak.arithmetic_calculator_with_compose.ui.theme.InputBlack

@Composable
@Preview(device = Devices.PIXEL_4, backgroundColor = 0xFFFFFFFF, showBackground = true)
fun InputAreaUI(
    currentExpression: String? = "10 x 5 + 30",
    result: String? = "80"
) {
    Column(
        modifier = Modifier
            .background(InputBlack)
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = currentExpression ?: "",
            modifier = Modifier.background(InputBlack),
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1
        )

        Text(
            text = result ?: "",
            modifier = Modifier.background(InputBlack),
            color = Color.White,
            style = MaterialTheme.typography.displayLarge,
            maxLines = 1
        )
    }
}