package uz.abdurashidov.foodapp.presentation.screens.detail.components

import androidx.compose.foundation.layout.Column
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

@Composable
fun IngredientSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp)
    ) {
        Text(text = "Ingredients", color = Color.White, fontSize = 14.sp, fontFamily = LoraMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "• 1 tblsp Olive Oil", color = DetailTextColor, fontFamily = LoraRegular)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "• 1 large Onion", color = DetailTextColor, fontFamily = LoraRegular)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "• 1 clove peeled crushed Garlic", color = DetailTextColor, fontFamily = LoraRegular)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "• 2 tblsp Worcestershire Sauce", color = DetailTextColor, fontFamily = LoraRegular)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "• 3 tsp Tomato Puree", color = DetailTextColor, fontFamily = LoraRegular)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "• 500g Turkey Mince", color = DetailTextColor, fontFamily = LoraRegular)
    }
}

@Preview
@Composable
private fun IngredientSectionPreview() {
    IngredientSection()
}