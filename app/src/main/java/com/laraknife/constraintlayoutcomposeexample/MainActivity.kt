package com.laraknife.constraintlayoutcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.laraknife.constraintlayoutcomposeexample.ui.theme.ConstraintLayoutComposeExampleTheme

class MainActivity : ComponentActivity() {

    /*
    Hecho por Brayan Josue Hernández Lara (LaraKnife)
    Viernes 03 de Noviembre de 2023
    Número de control: 192T0220
    Materia: Desarrollo de aplicaciones móviles
    Ingeniería en Sistemas Computacionales
    Noveno Semestre
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutComposeExampleTheme {
                Figures()
            }
        }
    }
}

@Composable
fun Figures(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // Create references for the composables to constrain
        val (box1, box2, box3, box4, box5) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(box1) {
                centerTo(parent)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(box2) {
                start.linkTo(box1.end)
                top.linkTo(box1.bottom)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(box3) {
                end.linkTo(box1.start)
                bottom.linkTo(box1.top)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(box4) {
                start.linkTo(box1.end)
                bottom.linkTo(box1.top)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(box5) {
                top.linkTo(box1.bottom)
                end.linkTo(box1.start)
            })

    }
}

@Preview(showSystemUi = true)
@Composable
fun FiguresPreview() {
    ConstraintLayoutComposeExampleTheme {
        Figures()
    }
}