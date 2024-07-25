package uz.abdurashidov.foodapp.presentation.screens.favorite.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.abdurashidov.foodapp.R
import uz.abdurashidov.foodapp.presentation.theme.LoraSemiBold

@Composable
fun FavoriteBar(modifier: Modifier = Modifier, backOnClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(text = "Favourite", color = Color.White, fontFamily = LoraSemiBold, fontSize = 24.sp   )
        Image(
            painter = painterResource(id = R.drawable.back_ic),
            contentDescription = null,
            modifier = Modifier.size(21.dp)
        )
    }

}