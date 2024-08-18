package lab6.uvg.edu.gt.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab6.uvg.edu.gt.ui.theme.Lab6Theme

@Composable
fun Historial(modifier: Modifier = Modifier) {
    val historial = remember { mutableStateListOf<Pair<Int, Boolean>>() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(historial.size) { index ->
            val (value, isIncrement) = historial[index]
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(if (isIncrement) Color.Green else Color.Red)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = value.toString(), color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun PreviewHistorial() {
    Lab6Theme {
        Historial()
    }
}
