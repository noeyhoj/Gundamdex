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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gundamdexapp.R
import com.example.gundamdexapp.ui.theme.GundamdexAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GundamdexDetail() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "RX-78-2",
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
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(350.dp)
                        .background(color = Color.Blue)
                )
            }
            item {
                GundamInfoCard(
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
private fun ArmamentsInfoCard(
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
        ArmamentInfoBar(
            name = "60mm Vulcan Gun",
            detail = "x2 (Head-mounted)",
        )
        ArmamentInfoBar(
            name = "Beam Saber",
            detail = "x2 (Backpack)",
        )
        ArmamentInfoBar(
            name = "Beam Rifle",
            detail = "Handheld (BOWA-XBR-M-79-07G)",
        )
        ArmamentInfoBar(
            name = "RX・M-Sh-008/S-01021 Shield",
            detail = "Arm-mounted / Handheld",
        )
    }
}

@Composable
private fun ArmamentInfoBar(
    name: String,
    detail: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .size(10.dp)
                .background(color = Color.Red, shape = CircleShape)
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

@Composable
private fun GundamInfoCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            "faction",
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
                "series",
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                "era",
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .padding(vertical = 2.dp, horizontal = 10.dp)
            )
        }
        Text("name", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Text("modelNumber", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text("description")
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
                Text("12.0 m")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
                    .weight(1f)
            ) {
                Text("Weight")
                Text("34.0 t")
            }
        }
    }
}

@Composable
private fun TechInfoCard(
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
            value = "1000W"
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Armor Material",
            value = "Luna Titanium Alloy"
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Total Thrust",
            value = "55,000 kg"
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Sensor Radius",
            value = "5,700 m"
        )
        HorizontalDivider(thickness = 2.dp)
        TechInfoBar(
            title = "Crew",
            value = "Pilot only (Core Block)"
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

@Preview(showBackground = true)
@Composable
private fun GundamInfoCardPreview() {
    GundamdexAppTheme {
        GundamInfoCard()
    }
}

@Preview(showBackground = true)
@Composable
private fun TechInfoCardPreview() {
    GundamdexAppTheme {
        TechInfoCard()
    }
}

@Preview(showBackground = true)
@Composable
private fun ArmamentsInfoCardPreview() {
    GundamdexAppTheme {
        ArmamentsInfoCard()
    }
}

@Preview(showBackground = true)
@Composable
private fun GundamdexDetailPreview() {
    GundamdexAppTheme {
        GundamdexDetail()
    }
}
