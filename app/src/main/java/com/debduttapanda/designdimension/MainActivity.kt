package com.debduttapanda.designdimension

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.debduttapanda.designdimension.ui.theme.DesignDimensionTheme
import com.debduttapanda.designdimension.ui.theme.fonts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignDimensionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xff34A53F)),
                        contentAlignment = Alignment.Center
                    ){
                        Box(
                            modifier = Modifier
                                .width(149.dep(270))
                                .height(93.dep(270))
                                .background(Color(0xffFF6060)),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                "Hello",
                                style = TextStyle(
                                    fontSize = 44.sep(270),
                                    //fontSize = 32.sp,
                                    fontFamily = fonts
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ep(
    dimension: Float,
    fullWidth: Float = 360f,
): Float{
    val context = LocalContext.current
    val density = LocalDensity.current.density
    val widthPx = context.resources.displayMetrics.widthPixels
    val factor = dimension/fullWidth
    return widthPx*factor/density
}

@Composable
fun dep(
    dimension: Float,//100
    fullWidth: Float = 360f,//2000
): Dp {
    return ep(dimension,fullWidth).dp
}

@Composable
fun sep(
    dimension: Float,//100
    fullWidth: Float = 360f,//2000
): TextUnit {

    return with(LocalDensity.current) {
        ep(dimension,fullWidth).dp.toSp()
    }
}

@Composable
fun Number.dep(fullWidth: Number = 360f): Dp{
    return dep(dimension = toFloat(),fullWidth = fullWidth.toFloat())
}

@Composable
fun Number.sep(fullWidth: Number = 360f): TextUnit{
    return sep(dimension = toFloat(),fullWidth = fullWidth.toFloat())
}