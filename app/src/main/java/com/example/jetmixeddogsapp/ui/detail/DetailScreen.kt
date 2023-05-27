package com.example.jetmixeddogsapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.jetmixeddogsapp.JetMixedDogsViewModel
import com.example.jetmixeddogsapp.ViewModelFactory
import com.example.jetmixeddogsapp.data.MixedDogsRepository
import com.example.jetmixeddogsapp.ui.theme.JetMixedDogsAppTheme
import com.example.jetmixeddogsapp.R

@Composable
fun DetailScreen(
    dogId: String,
    viewModel: JetMixedDogsViewModel = viewModel(
        factory = ViewModelFactory(MixedDogsRepository())
    )
) {
    viewModel.searchByID(dogId)
    val detailDog by viewModel.detailDog.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = detailDog?.photoUrl
        Image(
            painter = rememberAsyncImagePainter(image.toString()),
            contentDescription = "",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        detailDog?.let {
            Text(
                text = it.name,
                Modifier
                    .padding(top = 8.dp),
                lineHeight = 40.sp,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        detailDog?.let {
            Text(
                text = it.lifeSpan,
                modifier = Modifier
                    .padding(top = 8.dp),
                fontStyle = FontStyle.Italic,
            )
        }
        Text(
            text = stringResource(R.string.description) + "${detailDog?.description}",
            modifier = Modifier
                .padding(top = 8.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    JetMixedDogsAppTheme {
        DetailScreen(dogId = "9")
    }
}