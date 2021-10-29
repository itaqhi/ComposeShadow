package com.itaqhi.compose.shadow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itaqhi.compose.shadow.ui.theme.ComposeShadowTheme
import com.itaqhi.compose.shadow.ui.util.SoftSurface
import com.itaqhi.compose.shadow.ui.util.shadow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeShadowTheme {
                SoftSurface {
                    Shadows()
                }
            }
        }
    }
}

@Composable
fun Shadows() {
    Surface(
        color = Color(0xFFF4F7FE),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BoxA()
                BoxB()
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BoxC()
                BoxD()
            }
        }
    }
}

@Composable
fun BoxA() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .shadow(
                Shadow(
                    Color(0xFFDFDFDF),
                    Offset(0f, 6f),
                    12f
                ),
                RoundedCornerShape(24f)
            )
            .background(
                Color.White,
                RoundedCornerShape(24f)
            )
    )
}

@Composable
fun BoxB() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .shadow(
                Shadow(
                    Color(0x80009688),
                    Offset.Zero,
                    50f
                ),
                CircleShape
            )
            .background(
                Brush.horizontalGradient(listOf(Color.Blue, Color.Red)),
                CircleShape
            )
    )
}

@Composable
fun BoxC() {
    Box(
        modifier = Modifier
            .size(100.dp, 50.dp)
            .shadow(
                Shadow(
                    Color(0xCCF0B609),
                    Offset(6f, 6f),
                    10f
                ),
                CircleShape
            )
            .background(
                Color.White,
                CircleShape
            )
            .border(
                2.dp,
                Brush.linearGradient(listOf(Color.Blue, Color.Green)),
                CircleShape
            )
    )
}

@Composable
fun BoxD() {
    Box(
        modifier = Modifier
            .size(100.dp, 100.dp)
            .shadow(
                Shadow(
                    Color(0xFFC50AE6),
                    Offset.Zero,
                    100f
                ),
                GenericShape { size, _ ->
                    moveTo(size.width / 2, 0f)
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                }
            )
            .background(
                Brush.linearGradient(listOf(Color.Blue, Color.Green)),
                GenericShape { size, layoutDirection ->
                    moveTo(size.width / 2, 0f)
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                }
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Shadows()
}