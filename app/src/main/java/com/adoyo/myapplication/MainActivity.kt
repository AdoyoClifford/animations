package com.adoyo.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adoyo.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        var visible by remember {
                            mutableStateOf(false)
                        }
                        var isRound by remember {
                            mutableStateOf(false)
                        }
//                        val transition = updateTransition(targetState = isRound, label = null)
//                        val borderRadius by transition.animateInt(
//                            transitionSpec = { tween(2000) },
//                            label = "border radius",
//                            targetValueByState = { isRound ->
//                                if (isRound) 100 else 0
//                            }
//                        )
//                        val color by transition.animateColor(
//                            transitionSpec ={ tween(2000)},
//                            label = "color",
//                            targetValueByState = {isRound->
//                                if (isRound) Color.Red else Color.Green
//                            }
//                        )
//
//                        val transition = rememberInfiniteTransition()
//                        val color by transition.animateColor(
//                            initialValue = Color.Red,
//                            targetValue = Color.Green,
//                            animationSpec = infiniteRepeatable(
//                                animation = tween(2000),
//                                repeatMode = RepeatMode.Reverse
//                            )
//                        )
                        Button(onClick = {
                            visible = !visible
                            isRound = !isRound
                        }) {
                            Text(text = "Toggle")
                        }
//
//                        Box(
//                            modifier = Modifier
//                                .size(200.dp)
//                                .background(color)
//                        )
//                        AnimatedVisibility(
//                            visible = visible,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .weight(1f)
//                        ) {
//                            Box(modifier = Modifier
//                                .background(Color.Red)
//                                .fillMaxWidth()
//                                .weight(1f))
//                        }

                        AnimatedContent(
                            targetState = visible,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            content = {
                                if (visible) {
                                    Box(modifier = Modifier.background(Color.Red))
                                } else {
                                    Box(modifier = Modifier.background(Color.Green))
                                }
                            },
                            transitionSpec = {
                                slideInHorizontally(
                                    initialOffsetX = { -it }
                                ) with slideOutHorizontally(targetOffsetX = { it })
                            }
                        )
                    }
                }
            }
        }
    }
}


