package uz.abdurashidov.foodapp.presentation.screens.detail.components

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
import uz.abdurashidov.foodapp.presentation.theme.DetailTextColor
import uz.abdurashidov.foodapp.presentation.theme.LoraMedium
import uz.abdurashidov.foodapp.presentation.theme.LoraRegular
import uz.abdurashidov.foodapp.presentation.theme.LoraSemiBold

@Composable
fun IngredientSection(modifier: Modifier = Modifier, ingredients: List<Map<String, String>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Text(text = "Ingredients", color = Color.White, fontSize = 14.sp, fontFamily = LoraSemiBold)
        Spacer(modifier = Modifier.height(10.dp))

        for (ingredient in ingredients) {
            if (ingredient.keys.toString().isNotBlank()) {
                Row {
                    Text(
                        text = "• ${ingredient.values.map { it }[0]} ",
                        color = DetailTextColor,
                        fontFamily = LoraRegular
                    )
                    Text(
                        text = ingredient.keys.map { it }[0],
                        color = DetailTextColor,
                        fontFamily = LoraRegular
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}

//@Preview
//@Composable
//private fun IngredientSectionPreview() {
//    IngredientSection()
//}