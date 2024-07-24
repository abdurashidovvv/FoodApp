package uz.abdurashidov.foodapp.presentation.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.abdurashidov.foodapp.presentation.theme.LoraBold
import uz.abdurashidov.foodapp.presentation.theme.LoraSemiBold
import uz.abdurashidov.foodapp.presentation.theme.MainTextColor

@Composable
fun DescriptionSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Welcome ", fontSize = 20.sp, color = Color.White, fontFamily = LoraSemiBold)
            Text(text = "Denny", fontSize = 20.sp, color = MainTextColor, fontFamily = LoraSemiBold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "What would you like\n\n" +
                    "to cook today?",
            fontSize = 34.sp,
            fontFamily = LoraBold,
            color = MainTextColor
        )
    }
}

@Preview
@Composable
private fun DescriptionSectionPreview() {
    DescriptionSection()
}