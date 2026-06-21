package com.example.gundamdexapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = GundamBlue,
    onPrimary = White,

    // ✨ UI 스크린샷의 핵심: 배경은 옅은 회색, 카드는 순백색
    background = Gray50,
    onBackground = Gray900,

    surface = White,
    onSurface = Gray900,

    // 컴포넌트(카드, 검색창 등)의 기본 배경은 무조건 흰색이 되도록 강제
    surfaceContainerLowest = White,
    surfaceContainerLow = White,
    surfaceContainer = White,

    surfaceVariant = Gray100, // 보조 배경 (뱃지 등)
    onSurfaceVariant = Gray500, // 서브 텍스트 ("Gundam Wing" 같은 옅은 글씨)

    outline = Gray200, // 카드 테두리 선이나 구분선 색상
)

private val DarkColorScheme = darkColorScheme(
    primary = GundamBlueDark,
    onPrimary = DarkBackground,

    background = DarkBackground,
    onBackground = White,

    surface = DarkSurface,
    onSurface = White,

    surfaceContainerLowest = DarkBackground,
    surfaceContainerLow = DarkSurface,
    surfaceContainer = DarkSurface,

    surfaceVariant = DarkSurfaceElevated,
    onSurfaceVariant = Gray200,

    outline = Gray500,
)

@Composable
fun GundamdexAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme

        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
