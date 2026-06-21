package com.example.gundamdexapp.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.gundamdexapp.R
import com.example.gundamdexapp.data.domain.detail.mapper.toColor
import com.example.gundamdexapp.data.domain.detail.model.Armaments
import com.example.gundamdexapp.data.domain.detail.model.GundamInfo
import com.example.gundamdexapp.data.domain.detail.model.TechnicalSpecifications
import com.example.gundamdexapp.data.mock.GundamMockData
import com.example.gundamdexapp.ui.theme.GundamdexAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GundamdexDetail(
    gundamInfo: GundamInfo = GundamMockData.rx782Info
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        gundamInfo.name,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.download_back_arrow_icon),
                        contentDescription = "뒤로가기 아이콘",
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                GundamInfoCard(
                    gundamInfo = gundamInfo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
            }
            item {
                TechInfoCard(
                    technicalSpecifications = gundamInfo.technicalSpecifications,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 10.dp)
                )
            }
            item {
                ArmamentsInfoCard(
                    armaments = gundamInfo.armaments,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 10.dp)
                )
            }
        }
    }
}

@Composable
private fun GundamInfoCard(
    gundamInfo: GundamInfo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(gundamInfo.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "${gundamInfo.name} image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(16.dp)
                .size(350.dp)
        )

        Text(
            gundamInfo.faction,
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                .padding(vertical = 2.dp, horizontal = 10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                gundamInfo.series,
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                gundamInfo.era,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .padding(vertical = 2.dp, horizontal = 10.dp)
            )
        }
        Text(gundamInfo.name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Text(gundamInfo.modelNumber, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(gundamInfo.description)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Text("Height")
                Text(gundamInfo.dimensions.height)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Text("Weight")
                Text(gundamInfo.dimensions.weight)
            }
        }
    }
}

@Composable
private fun TechInfoCard(
    technicalSpecifications: TechnicalSpecifications,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        InfoTitle(
            iconId = R.drawable.download_tech_icon,
            title = "Technical Specifications",
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Generator Output",
            value = technicalSpecifications.generatorOutput
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Armor Material",
            value = technicalSpecifications.armorMaterial
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Total Trust",
            value = technicalSpecifications.totalTrust
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Sensor Radius",
            value = technicalSpecifications.sensorRadius
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Crew",
            value = technicalSpecifications.crew
        )
    }
}

@Composable
private fun InfoTitle(
    iconId: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = "$title icon",
            modifier = Modifier
                .size(40.dp)
                .padding(horizontal = 10.dp)
        )
        Text(title)
    }
}

@Composable
private fun TechInfoBar(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
        Text(value)
    }
}

@Composable
private fun ArmamentsInfoCard(
    armaments: Armaments,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        InfoTitle(
            iconId = R.drawable.download_attack_icon,
            title = "Standard Armaments"
        )
        HorizontalDivider(thickness = 2.dp)
        armaments.value.forEach { (name, details, indicatorColor) ->
            ArmamentInfoBar(
                name = name,
                detail = details,
                indicatorColor = indicatorColor.toColor()
            )
        }
    }
}

@Composable
private fun ArmamentInfoBar(
    name: String,
    detail: String,
    indicatorColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(10.dp)
                .background(color = indicatorColor, shape = CircleShape)
        )
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(name)
            Text(detail)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun GundamInfoCardPreview() {
    GundamdexAppTheme {
        GundamInfoCard(
            gundamInfo = GundamMockData.rx782Info
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TechInfoCardPreview() {
    GundamdexAppTheme {
        TechInfoCard(
            technicalSpecifications = GundamMockData.rx782Info.technicalSpecifications
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ArmamentsInfoCardPreview() {
    GundamdexAppTheme {
        ArmamentsInfoCard(
            armaments = GundamMockData.rx782Info.armaments
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GundamdexDetailPreview() {
    GundamdexAppTheme {
        GundamdexDetail()
    }
}
