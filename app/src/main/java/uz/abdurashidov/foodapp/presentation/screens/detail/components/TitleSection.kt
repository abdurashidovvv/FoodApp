package uz.abdurashidov.foodapp.presentation.screens.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.abdurashidov.foodapp.R
import uz.abdurashidov.foodapp.presentation.theme.LaunchTimeTextColor
import uz.abdurashidov.foodapp.presentation.theme.LoraMedium
import uz.abdurashidov.foodapp.presentation.theme.LoraRegular
import uz.abdurashidov.foodapp.presentation.theme.LoraSemiBold

@Composable
fun TitleSection(modifier: Modifier = Modifier, foodName:String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column {
            Text(
                text = "Breakfast",
                fontFamily = LoraRegular,
                color = LaunchTimeTextColor,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = foodName,
                fontFamily = LoraSemiBold,
                color = Color.White,
                fontSize = 21.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null, modifier = Modifier.size(15.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null, modifier = Modifier.size(15.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null, modifier = Modifier.size(15.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null, modifier = Modifier.size(15.dp))
                Image(painter = painterResource(id = R.drawable.star), contentDescription = null, modifier = Modifier.size(15.dp))
            }
        }
        Image(
            painter = painterResource(id = R.drawable.dislike_white),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}

//@Preview
//@Composable
//private fun TitleSectionPreview() {
//    TitleSection()
//}