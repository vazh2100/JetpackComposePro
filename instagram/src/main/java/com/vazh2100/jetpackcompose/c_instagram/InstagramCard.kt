package com.vazh2100.jetpackcompose.c_instagram

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vazh2100.jetpackcompose.R
import com.vazh2100.jetpackcompose.d_viewmodel.MainViewModel

@Composable
fun InstagramCard(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {

    val followed by mainViewModel.isFollowed.observeAsState(false)

    Card(
        colors = CardDefaults.cardColors(),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface),
        modifier = modifier.padding(16.dp),
        content = {
            Column(
                modifier = modifier.padding(8.dp),
                content = {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Image(
                                modifier = Modifier.size(48.dp),
                                painter = painterResource(R.drawable.instagram),
                                contentDescription = "Instagram Logo",
                            )
                            UserStat("6,960", "Posts")
                            UserStat("436 M", "Followers")
                            UserStat("76", "Following")
                        })
                    Column(
                        modifier = Modifier.padding(start = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            Text(
                                text = "Instagram",
                                fontFamily = FontFamily.Cursive,
                                fontSize = 28.sp,
                                lineHeight = 28.sp
                            )
                            Text(
                                text = "#YoursToMake",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 12.sp,
                                lineHeight = 12.sp
                            )
                            Text(
                                text = "https://facebook.com",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 12.sp,
                                lineHeight = 12.sp
                            )
                            FollowButton(
                                followed = followed,
                                onClick = mainViewModel::changeFollowingStatus,
                            )

                        },
                    )
                },
            )
        },
    )
}

@Composable
fun FollowButton(
    followed: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = run {
                val color = MaterialTheme.colorScheme.primary
                if (followed) color.copy(alpha = 0.3f) else color
            },
        ),
        content = {
            val text = if (followed) "Unfollow" else "Follow"
            Text(text)
        },
    )
}

@Composable
fun UserStat(
    value: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(text = value, fontFamily = FontFamily.Cursive, fontSize = 28.sp)
            Text(text = title, fontFamily = FontFamily.Monospace)
        },
    )
}