package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.OnPrimary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Primary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.PrimaryContainer
import com.github.thailandandroiddeveloper.common.ui.theme.Typography

@Composable
fun Qualify1Screen() {
    Column(
        modifier = Modifier.background(OnPrimary)
    ) {
        TopBar()
        Body()
    }
}

@Composable
fun Body() {
    Box(
        modifier = Modifier.padding(bottom = 48.dp)
    ) {
        Card(
            shape = RoundedCornerShape(4),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painterResource(R.drawable.img_qualify_1_profile),
                    "Profile Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .height(192.dp)
                        .background(Primary.copy(alpha = 0.75f))
                ) {
                    Text(
                        "John Doe", maxLines = 1,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 18.8.dp),
                        color = OnPrimary,
                        style = Typography.headlineMedium,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.W400,
                    )

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 8.dp)
                    ) {
                        Image(
                            painterResource(R.drawable.ic_qualify_1_gender_male),
                            "content description",
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .size(16.dp)
                        )
                        Text(
                            "Male", maxLines = 1,
                            modifier = Modifier.padding(start = 8.dp),
                            color = OnPrimary,
                            style = Typography.bodyMedium,
                            letterSpacing = 0.25.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = FontFamily.SansSerif,
                        )
                    }
                    Text(
                        "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        color = OnPrimary,
                        style = Typography.bodyMedium,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = 0.3.sp,
                    )

                }
            }
        }
        Row(modifier = Modifier.align(Alignment.BottomCenter)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(
                    color = Color(0xFFF9DEDC), shape = RoundedCornerShape(size = 100.dp)
                )
            ) {
                Image(
                    painterResource(R.drawable.ic_qualify_1_thumb_down),
                    "Dislike",
                    modifier = Modifier
                        .padding(horizontal = 48.dp)
                        .padding(vertical = 12.dp)
                        .size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(43.dp))
            Column(
                modifier = Modifier.background(
                    color = PrimaryContainer, shape = RoundedCornerShape(size = 100.dp)
                )
            ) {
                Image(
                    painterResource(R.drawable.ic_qualify_1_thumb_up),
                    "Like",
                    modifier = Modifier
                        .padding(horizontal = 48.dp)
                        .padding(vertical = 12.dp)
                        .size(24.dp)
                )
            }
        }

    }

}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .height(64.dp)
            .background(color = Color(0xFFEADDFF))
            .fillMaxWidth()
    ) {
        val imageModifier = Modifier
            .size(48.dp)
            .fillMaxSize()
            .align(alignment = Alignment.CenterVertically)
        Image(
            painter = painterResource(R.drawable.ic_qualify_1_menu), "Menu",
            modifier = imageModifier.padding(start = 8.dp),
            contentScale = ContentScale.Crop,
        )
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Image(
            painterResource(R.drawable.ic_qualify_1_profile),
            "Profile",
            modifier = imageModifier.padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion