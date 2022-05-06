package com.example.badgermecohort1.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.badgermecohort1.R

@Preview
@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            tint = color,

            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MyComponent(
    modifier: Modifier = Modifier,
) {
    Box(contentAlignment = Alignment.TopEnd) {

        Image(
            contentScale = ContentScale.None,
            modifier = modifier,
            painter = painterResource(R.drawable.square_3),
            contentDescription = null
        )

        FavoriteButton(modifier = Modifier.padding(12.dp))

    }
}
