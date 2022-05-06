package com.example.badgermecohort1.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.badgermecohort1.R

@Preview(showBackground = true)
@Composable
fun interestsImagePreview() {

    var isSelected by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Image(
                painter = painterResource(R.drawable.square_3),
                contentDescription = "contentDescription",
                modifier = Modifier.matchParentSize()
            )
            IconToggleButton(
                checked = isSelected,
                onCheckedChange = { isSelected = !isSelected }
            ) {
                Icon(
                    imageVector = if (isSelected) {
                        Icons.Default.AccountCircle
                    } else {
                        Icons.Default.CheckCircle
                    },
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(7.dp)
                        .padding(top = 1.dp, end = 1.dp)
                        .align(Alignment.TopEnd)
                )
            }

        }
        Text(
            text = "Walks",
            fontSize = 6.sp,
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(R.color.off_black),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}



@Composable
fun interestsImage(
    imageResourceId : Int,
    contentDescription: String = "content description",
    imageContainerTitle: String,
    modifier: Modifier = Modifier
) {
    var isSelected by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = contentDescription,
                modifier = Modifier.matchParentSize()
                        .padding(5.dp)
                        .size(96.dp)
            )
            IconToggleButton(
                checked = isSelected,
                onCheckedChange = { isSelected = !isSelected }
            ) {
                Icon(
                    imageVector = if (isSelected) {
                        Icons.Default.AccountCircle
                    } else {
                        Icons.Default.CheckCircle
                    },
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(7.dp)
                        .padding(top = 1.dp, end = 1.dp)
                        .align(Alignment.TopEnd)
                )
            }

        }
        Text(
            text = imageContainerTitle,
            fontSize = 6.sp,
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(R.color.off_black),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

