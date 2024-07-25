package uz.abdurashidov.foodapp.presentation.screens.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.abdurashidov.foodapp.R

@Composable
fun DetailBar(modifier: Modifier = Modifier, backOnClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_ic),
            contentDescription = null,
            modifier = Modifier
                .size(27.dp)
                .clickable {
                    backOnClicked()
                }
        )
        Image(
            painter = painterResource(id = R.drawable.notification_ic),
            contentDescription = null,
            modifier = Modifier.size(27.dp)
        )
    }
}

//@Preview
//@Composable
//private fun DetailBarPreview() {
//    DetailBar()
//}