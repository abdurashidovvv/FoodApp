package uz.abdurashidov.foodapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import uz.abdurashidov.foodapp.R
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.presentation.theme.LaunchTimeTextColor
import uz.abdurashidov.foodapp.presentation.theme.LoraMedium
import uz.abdurashidov.foodapp.presentation.theme.LoraRegular
import uz.abdurashidov.foodapp.presentation.theme.MainTextColor

@Composable
fun MainSection(modifier: Modifier = Modifier, foods: List<Food>) {
    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Today’s Fresh Recipe",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = LoraMedium
            )
            Text(text = "See All", fontSize = 18.sp, color = MainTextColor, fontFamily = LoraMedium)
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow {
            items(foods) { food ->
                MainRecipeCard(food = food)
            }
        }
    }
}

@Composable
fun MainRecipeCard(modifier: Modifier = Modifier, food: Food) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF707070)
        ),
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp)
                )

                Spacer(modifier = Modifier.width(40.dp))
                SubcomposeAsyncImage(
                    model = food.foodImageURL,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = food.foodName,
                    modifier = Modifier
                        .size(99.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }

            Text(
                text = "Breakfast",
                color = Color(0xFF2958FF),
                fontFamily = LoraRegular,
                fontSize = 10.sp
            )
            Text(
                text = food.foodName,
                color = Color.White,
                fontFamily = LoraRegular,
                fontSize = 10.sp
            )

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = null,
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "10:03",
                    fontFamily = LoraRegular,
                    fontSize = 10.sp,
                    color = MainTextColor
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainSectionPreview() {
    MainSection(foods = listOf())
}