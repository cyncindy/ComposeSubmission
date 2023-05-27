package com.example.jetmixeddogsapp.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetmixeddogsapp.R
import com.example.jetmixeddogsapp.ui.theme.JetMixedDogsAppTheme

@Composable
fun AboutScreen (

){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text(
            stringResource(R.string.about_me),
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Image(
            painterResource(R.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(200.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(R.string.full_name),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            stringResource(R.string.email_address),
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    JetMixedDogsAppTheme {
        AboutScreen()
    }
}