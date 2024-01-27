package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.OnPrimary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.OnPrimaryContainer
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.OnSurface
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.OnSurfaceVariant
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Outline
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Primary
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.PrimaryContainer
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.Surface
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.SurfaceContainerLowest
import com.github.thailandandroiddeveloper.common.ui.theme.LightColors.SurfaceVariant
import com.github.thailandandroiddeveloper.common.ui.theme.Typography

data class Profile(
    val id: Int,
    val image: Int,
    val desc: String,
    val isSelected: Boolean,
)

object ProfileDetail {
    val ProfileList = listOf(
        Profile(
            1,
            R.drawable.img_qualify_3_photo_1,
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
            true
        ),
        Profile(
            2,
            R.drawable.img_qualify_3_photo_2,
            "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
            false
        ),
        Profile(
            3,
            R.drawable.img_qualify_3_photo_3,
            "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
            false
        ),
        Profile(
            4,
            R.drawable.img_qualify_3_photo_3,
            "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibhmolestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget.",
            false
        ),
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Qualify3Screen() {
    Scaffold(content = {
        Column(
            modifier = Modifier
                .background(OnPrimary)
                .fillMaxSize()
        ) {
            TopBar()
            ProfilePager(profiles = ProfileDetail.ProfileList)
            TagContent()
            CommentContent()
        }
    })
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfilePager(profiles: List<Profile>) {
    val pagerState = rememberPagerState(pageCount = { profiles.size })
    Column(
        modifier = Modifier.background(SurfaceContainerLowest)
    ) {
        HorizontalPager(
            pageSize = PageSize.Fixed(176.dp), state = pagerState
        ) {
            val current = profiles[it]

            val textColor =  if (pagerState.currentPage == it)  Primary else PrimaryContainer

            Row(
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(160.dp)
                        .height(320.dp)
                        .shadow(
                            elevation = 0.1.dp, shape = RoundedCornerShape(16.dp)
                        )
                        .background(textColor)
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(1.9.dp)
                            .shadow(
                                elevation = 0.15.dp, shape = RoundedCornerShape(15.dp)
                            )
                            .scale(1.013f),
                        painter = painterResource(current.image),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}

@Composable
fun TagListItem(image: Profile) {
    val textColor = if (image.isSelected) Primary else Outline
    Box(
        modifier = Modifier
            .padding(start = 8.dp)
            .border(
                width = 0.8.dp, color = textColor, shape = RoundedCornerShape(size = 8.dp)
            )
            .width(68.dp)
            .height(32.dp)
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.CenterVertically),
        ) {
            Text(
                style = Typography.labelLarge,
                fontFamily = FontFamily.SansSerif,
                letterSpacing = 0.25.sp,
                text = "Tag ${image.id}",
                color = textColor,
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun TagContent() {
    val profiles = remember { ProfileDetail.ProfileList }
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp)
            .padding(horizontal = 8.dp),
    ) {
        items(
            items = profiles,
            itemContent = {
                TagListItem(image = it)
            })
    }
}

@Composable
fun CommentContent() {
    val profiles = remember { ProfileDetail.ProfileList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(
            profiles
        ) {
            CommentItem(it)
        }
    }
}

@Composable
fun CommentItem(profile: Profile) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .border(
                width = 1.dp, color = SurfaceVariant, shape = RoundedCornerShape(size = 16.dp)
            )
            .width(379.dp)
            .background(color = Surface, shape = RoundedCornerShape(size = 16.dp))
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.img_qualify_3_sender),
                contentDescription = "avatar",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    style = Typography.titleMedium,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.1.sp,
                    color = OnSurface,
                    text = "Lorem Ipsum"
                )
                Text(
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.35.sp,
                    maxLines = 2,
                    color = OnSurfaceVariant,
                    overflow = TextOverflow.Ellipsis,
                    text = profile.desc,
                    modifier = Modifier.padding(top = 2.5.dp)
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
            .background(color = PrimaryContainer)
    ) {
        val imageModifier = Modifier
            .size(48.dp)
            .fillMaxSize()
            .align(alignment = Alignment.CenterVertically)
        Image(
            painter = painterResource(R.drawable.ic_qualify_3_back), "content description",
            modifier = imageModifier.padding(start = 8.dp),
            contentScale = ContentScale.Crop,
        )
        Text(
            style = Typography.titleLarge,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 0.1.sp,
            lineHeight = 28.sp,
            color = OnPrimaryContainer,
            text = "John Doe",
            modifier = Modifier
                .padding(start = 8.dp)
                .padding(top = 15.dp)
                .wrapContentHeight(align = Alignment.Top),
        )
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Image(
            painterResource(R.drawable.ic_qualify_3_copy),
            "copy",
            modifier = imageModifier.padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painterResource(R.drawable.ic_qualify_3_calendar),
            "calender",
            modifier = imageModifier.padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painterResource(R.drawable.ic_qualify_3_menu),
            "menu",
            modifier = imageModifier.padding(end = 9.dp),
            contentScale = ContentScale.Crop
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion