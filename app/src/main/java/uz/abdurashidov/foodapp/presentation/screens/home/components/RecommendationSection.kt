package uz.abdurashidov.foodapp.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import uz.abdurashidov.foodapp.R
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.presentation.screens.home.HomeScreenViewModel
import uz.abdurashidov.foodapp.presentation.theme.LoraRegular
import uz.abdurashidov.foodapp.presentation.theme.MainTextColor

@Composable
fun RecommendationSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recommended",
                fontSize = 18.sp,
                fontFamily = LoraRegular,
                color = Color.White
            )
            Text(
                text = "See All",
                fontSize = 18.sp,
                fontFamily = LoraRegular,
                color = MainTextColor
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

    }
}

@Composable
fun RecommendationItemCard(
    modifier: Modifier = Modifier,
    foodCardOnClicked: (String) -> Unit,
    food: Food,
    likedOnClicked: (Food) -> Unit,
    homeScreenViewModel: HomeScreenViewModel,
    isFav: Boolean
) {
    LaunchedEffect(key1 = food) {
        homeScreenViewModel.isFavoriteUseCase(food = food)
    }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF373737)
        ),
        modifier = Modifier
            .clickable {
                foodCardOnClicked(food.foodId)
            }
            .padding(bottom = 5.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 5.dp, horizontal = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(end = 40.dp) // Add some padding to the end to avoid overlap with the corner icon
            ) {
                SubcomposeAsyncImage(
                    model = food.foodImageURL,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = food.foodName,
                    modifier = Modifier.size(65.dp)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = food.foodName,
                        fontSize = 18.sp,
                        color = Color.White,
                        fontFamily = LoraRegular
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            Modifier.size(15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            Modifier.size(15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            Modifier.size(15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            Modifier.size(15.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            Modifier.size(15.dp)
                        )
                    }
                }
            }

            Image(
                painter = painterResource(id = if (isFav) R.drawable.like else R.drawable.dislike),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        likedOnClicked(food)
                    }
                    .size(44.dp)
                    .align(Alignment.TopEnd) // Align to the top end (top right) corner
                    .padding(8.dp) // Add some padding to avoid overlap with the edge
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Align to the bottom end (bottom right) corner
                    .padding(8.dp) // Add some padding to avoid overlap with the edge
            ) {
                Image(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = null,
                    modifier = Modifier.size(13.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "10:03",
                    fontFamily = LoraRegular,
                    color = MainTextColor
                )
            }
        }
    }
}

@Preview
@Composable
private fun RecommendationSectionPreview() {
    RecommendationSection()
}