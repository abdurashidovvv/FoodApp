package uz.abdurashidov.foodapp.presentation.screens.components

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
fun AppBar(modifier: Modifier = Modifier, menuOnClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.burger_menu),
            contentDescription = "menu_ic",
            modifier = Modifier
                .size(25.dp)
                .clickable {
                    menuOnClicked()
                }
        )
        Image(
            painter = painterResource(id = R.drawable.notification_ic),
            contentDescription = "notification_ic",
            modifier = Modifier.size(25.dp)
        )
    }
}

@Preview
@Composable
private fun AppBarPreview() {
    AppBar(modifier = Modifier, menuOnClicked = {})
}