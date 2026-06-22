package com.example.gundamdexapp.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.gundamdexapp.R
import com.example.gundamdexapp.ui.theme.GundamBlue
import com.example.gundamdexapp.ui.theme.GundamdexAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GundamdexHome(
    gundamdexHomeUiState: GundamdexHomeUiState,
    onCardClick: (String) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Gundamdex",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = GundamBlue,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
            )
        },
    ) { innerPadding ->
        var searchTextValue by remember { mutableStateOf("") }

        fun onSearchTextValueChange(changeValue: String) {
            searchTextValue = changeValue
        }

        GundamdexContent(
            searchTextValue = searchTextValue,
            onSearchTextValueChange = {
                onSearchTextValueChange(it)
            },
            onCardClick = { id ->
                onCardClick(id)
            },
            gundamdexHomeUiState = gundamdexHomeUiState,
            sharedTransitionScope = sharedTransitionScope,
            animatedVisibilityScope = animatedVisibilityScope,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        )
    }
}

@Composable
private fun GundamdexContent(
    searchTextValue: String,
    onSearchTextValueChange: (String) -> Unit,
    gundamdexHomeUiState: GundamdexHomeUiState,
    onCardClick: (String) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        GundamdexSearchBar(
            searchTextValue = searchTextValue,
            onSearchTextValueChange = onSearchTextValueChange,
            modifier = Modifier.padding(16.dp),
        )

        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item(
                span = { GridItemSpan(2) },
            ) {
                Text(
                    "Featured Units",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }
            items(
                gundamdexHomeUiState.gundamInfoList,
                key = { it.id },
            ) {
                GundamCard(
                    id = it.id,
                    modelNumber = it.modelNumber,
                    gundamName = it.name,
                    gundamSeries = it.series,
                    imageUrl = it.imageUrl,
                    onCardClick = {
                        onCardClick(it.id)
                    },
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope,
                    modifier = Modifier
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(10.dp),
                )
            }
        }
    }
}

@Composable
private fun GundamdexSearchBar(
    searchTextValue: String,
    onSearchTextValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Surface(
            modifier = Modifier.shadow(elevation = 6.dp, shape = RoundedCornerShape(10.dp)),
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.download_search_icon),
                        contentDescription = "검색 아이콘",
                        modifier = Modifier.size(20.dp),
                    )
                },
                placeholder = {
                    Text("Search archive...")
                },
                maxLines = 1,
                shape = RoundedCornerShape(10.dp),
                value = searchTextValue,
                onValueChange = onSearchTextValueChange,
            )
        }
    }
}

@Composable
private fun GundamCard(
    id: String,
    modelNumber: String,
    gundamName: String,
    gundamSeries: String,
    imageUrl: String,
    onCardClick: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier,
) {
    with(sharedTransitionScope) {
        Column(
            modifier = modifier
                .sharedBounds(
                    rememberSharedContentState(key = "$id gundam"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    enter = fadeIn(),
                    exit = fadeOut(),
                    resizeMode = SharedTransitionScope.ResizeMode.scaleToBounds(),
                )
                .clickable {
                    onCardClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(false)
                    .build(),
                contentDescription = "$gundamName image",
                modifier = Modifier
                    .sharedElement(
                        sharedContentState = rememberSharedContentState(
                            key = "$id image",
                        ),
                        animatedVisibilityScope = animatedVisibilityScope,
                    )
                    .size(150.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)),
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    modelNumber,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    gundamName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    gundamSeries,
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GundamCardPreview() {
    GundamdexAppTheme {
        SharedTransitionLayout {
            AnimatedVisibility(visible = true) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .width(170.dp),
                ) {
                    GundamCard(
                        modelNumber = "Model Number",
                        gundamName = "Gundam Name",
                        gundamSeries = "Gundam Series",
                        imageUrl = "",
                        id = "",
                        onCardClick = {},
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = this@AnimatedVisibility,
                        modifier = Modifier
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                            .padding(10.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GundamdexSearchBarPreview() {
    GundamdexAppTheme {
        GundamdexSearchBar(
            searchTextValue = "",
            onSearchTextValueChange = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GundamdexHomePreview() {
    GundamdexAppTheme {
        SharedTransitionLayout {
            AnimatedVisibility(visible = true) {
                GundamdexHome(
                    gundamdexHomeUiState = GundamdexHomeUiState(),
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedVisibility,
                    onCardClick = {},
                )
            }
        }
    }
}
