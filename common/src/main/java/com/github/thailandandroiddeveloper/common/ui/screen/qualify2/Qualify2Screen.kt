package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.OnPrimary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Primary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.PrimaryContainer
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.SurfaceContainerLowest
import com.github.thailandandroiddeveloper.common.ui.theme.Typography

data class Onboarding(
    val id: Int,
    val image: Int,
    val title: String,
    val desc: String,
    val isSelected: Boolean,
)

object OnboardingDetail {
    val OnboardingList = listOf(
        Onboarding(
            1,
            R.drawable.img_qualify_2_onboard,
            "Lorem ipsum dolor sit amet 1",
            "Lorem ipsum dolor sit amet, consectetur adipiscing" + "\nelit. Donec egestas dictum lacinia. Integer arcu" + "\nneque, porttitor ac metus quis, iaculis molestie" + "\nmagna. Vivamus molestie justo sed nulla lacinia, quis" + "\nfringilla lorem imperdiet. Proin in quam vel odio" + "\niaculis fringilla",
            false
        ),
        Onboarding(
            2,
            R.drawable.img_qualify_2_onboard,
            "Lorem ipsum dolor sit amet 2",
            "Lorem ipsum dolor sit amet, consectetur adipiscing" + "\nelit. Donec egestas dictum lacinia. Integer arcu" + "\nneque, porttitor ac metus quis, iaculis molestie" + "\nmagna. Vivamus molestie justo sed nulla lacinia, quis" + "\nfringilla lorem imperdiet. Proin in quam vel odio" + "\niaculis fringilla",
            false
        ),
        Onboarding(
            3,
            R.drawable.img_qualify_2_onboard,
            "Lorem ipsum dolor sit amet 3",
            "Lorem ipsum dolor sit amet, consectetur adipiscing" + "\nelit. Donec egestas dictum lacinia. Integer arcu" + "\nneque, porttitor ac metus quis, iaculis molestie" + "\nmagna. Vivamus molestie justo sed nulla lacinia, quis" + "\nfringilla lorem imperdiet. Proin in quam vel odio" + "\niaculis fringilla",
            false
        ),
        Onboarding(
            4,
            R.drawable.img_qualify_2_onboard,
            "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing" + "\nelit. Donec egestas dictum lacinia. Integer arcu" + "\nneque, porttitor ac metus quis, iaculis molestie" + "\nmagna. Vivamus molestie justo sed nulla lacinia, quis" + "\nfringilla lorem imperdiet. Proin in quam vel odio" + "\niaculis fringilla",
            false
        ),
        Onboarding(
            5,
            R.drawable.img_qualify_2_onboard,
            "Lorem ipsum dolor sit amet 4",
            "Lorem ipsum dolor sit amet, consectetur adipiscing" + "\nelit. Donec egestas dictum lacinia. Integer arcu" + "\nneque, porttitor ac metus quis, iaculis molestie" + "\nmagna. Vivamus molestie justo sed nulla lacinia, quis" + "\nfringilla lorem imperdiet. Proin in quam vel odio" + "\niaculis fringilla",
            false
        ),
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Qualify2Screen() {

    Scaffold(content = {
        Column(
            modifier = Modifier
                .background(SurfaceContainerLowest)
                .fillMaxSize(),
        ) {
            Onboarding()
            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(SurfaceContainerLowest)
            )
            ContentBottom()
        }
    })
}

@Composable
fun ContentBottom() {

    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .background(
                color = PrimaryContainer
            )
            .height(102.dp)
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(
                    color = Primary, shape = RoundedCornerShape(size = 100.dp)
                )
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                style = Typography.labelLarge,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W500,
                color = OnPrimary,
                text = "Next",
                modifier = Modifier
                    .padding(vertical = 10.5.dp)
                    .padding(horizontal = 110.5.dp)
            )
        }
    }

}

@Composable
fun Onboarding() {
    Column(
        modifier = Modifier.background(OnPrimary)
    ) {

        Text(
            style = Typography.labelLarge,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 0.15.sp,
            color = Primary,
            text = "Skip",
            modifier = Modifier
                .align(Alignment.End)
                .padding(horizontal = 20.dp)
                .padding(top = 18.dp)
                .padding(end = 1.8.dp)
        )
        CustomViewPager(onboardings = OnboardingDetail.OnboardingList)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomViewPager(onboardings: List<Onboarding>) {
    val pagerState = rememberPagerState(pageCount = { onboardings.size }, initialPage = 3)
    Column(
        modifier = Modifier.background(SurfaceContainerLowest)
    ) {
        HorizontalPager(state = pagerState) {
            val current = onboardings[it]
            Column(
                modifier = Modifier.background(OnPrimary)
            ) {
                Text(
                    style = Typography.headlineSmall,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.SansSerif,
                    color = LightColors.OnSurface,
                    text = current.title,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 28.1.dp)
                )
                Text(
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.32.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center,
                    color = LightColors.OnSurface,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(horizontal = 32.dp)
                        .align(Alignment.CenterHorizontally),
                    text = current.desc
                )
                Image(
                    painter = painterResource(current.image),
                    contentDescription = "Image Onboarding",
                    modifier = Modifier
                        .height(478.dp)
                        .padding(top = 32.5.dp)
                        .padding(horizontal = 32.dp)
                        .fillMaxSize()
                        .shadow(
                            elevation = 0.5.dp, shape = RoundedCornerShape(16.dp)
                        ),
                    contentScale = ContentScale.FillBounds,
                )
            }

        }

        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                if (pagerState.currentPage == iteration) {
                    Box(
                        modifier = Modifier
                            .padding(top = 32.dp)
                            .padding(horizontal = 4.7.dp)
                            .clip(CircleShape)
                            .background(color = Primary)
                            .width(32.dp)
                            .height(16.dp)
                    )

                } else {
                    Box(
                        modifier = Modifier
                            .padding(top = 32.dp)
                            .padding(horizontal = 4.7.dp)
                            .clip(CircleShape)
                            .background(color = PrimaryContainer)
                            .size(16.dp)
                    )
                }

            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion