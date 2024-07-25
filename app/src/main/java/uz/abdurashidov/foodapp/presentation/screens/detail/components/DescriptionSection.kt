package uz.abdurashidov.foodapp.presentation.screens.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import uz.abdurashidov.foodapp.R
import uz.abdurashidov.foodapp.presentation.theme.DetailTextColor
import uz.abdurashidov.foodapp.presentation.theme.LoraRegular

@Composable
fun DescriptionSection(modifier: Modifier = Modifier, foodArea: String, foodImageURL: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.time_ic),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "25 mins",
                    color = DetailTextColor,
                    fontSize = 14.sp,
                    fontFamily = LoraRegular
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.lang_ic),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = foodArea,
                    color = DetailTextColor,
                    fontSize = 14.sp,
                    fontFamily = LoraRegular
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.meal_ic),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "1 Serving",
                    color = DetailTextColor,
                    fontSize = 14.sp,
                    fontFamily = LoraRegular
                )
            }
        }

        SubcomposeAsyncImage(
            model = foodImageURL,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = foodArea,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(30.dp))
        )
    }
}

//@Preview
//@Composable
//private fun DescriptionSectionPreview() {
//    DescriptionSection()
//}