package uz.abdurashidov.foodapp.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.abdurashidov.foodapp.R

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    val searchState = remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        OutlinedTextField(
            value = searchState.value,
            onValueChange = { searchState.value = it },
            label = { Text("Search Recipe") },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_ic),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            },
            modifier = Modifier.fillMaxWidth(.8f)
        )
        Card(
            modifier = Modifier
                .size(50.dp)
                .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Black
            )
        )  {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.vfilter_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchBarSectionPerview() {
    SearchBar()
}