package com.vazh2100.jetpackcompose.e_lazy_column

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vazh2100.jetpackcompose.R
import com.vazh2100.jetpackcompose.c_instagram.FollowButton
import com.vazh2100.jetpackcompose.c_instagram.UserStat

@Composable
fun InstagramCard(
    followed: Boolean,
    onCardPress: () -> Unit,
    modifier: Modifier = Modifier,
) {
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
                                onClick = onCardPress
                            )

                        },
                    )
                },
            )
        },
    )
}

