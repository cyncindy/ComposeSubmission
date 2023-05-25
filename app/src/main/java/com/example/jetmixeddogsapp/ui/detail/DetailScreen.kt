package com.example.jetmixeddogsapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetmixeddogsapp.model.MixedDogs

@Composable
fun DetailScreen(
    mixedDogs: MixedDogs,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        val url = mixedDogs.photoUrl
        Image(
            painter = rememberImagePainter(url.toString()),
            contentDescription = "",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "Description : ",
            modifier = Modifier
            .padding(top = 8.dp))
        Text(
            text = "",
            modifier = Modifier
                .padding(top = 8.dp)

        )
    }
}