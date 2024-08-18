package lab6.uvg.edu.gt.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lab6.uvg.edu.gt.ui.theme.CorrectGreen
import lab6.uvg.edu.gt.ui.theme.Lab6Theme

@Composable
fun Contador(
    contador: Int,
    incrementos: Int,
    decrementos: Int,
    maximo: Int,
    minimo: Int,
    historial: List<Pair<Int, Boolean>>,
    onIncrementar: () -> Unit,
    onDecrementar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Paula De León", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = onDecrementar) {
                Text(text = "−", fontSize = 24.sp)
            }

            Text(
                text = contador.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(onClick = onIncrementar) {
                Text(text = "+", fontSize = 24.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = "Total incrementos: $incrementos")
            Text(text = "Total decrementos: $decrementos")
            Text(text = "Valor máximo: $maximo")
            Text(text = "Valor mínimo: $minimo")
            Text(text = "Total cambios: ${incrementos + decrementos}")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Historial:", fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            items(historial) { item ->
                val color = if (item.second) CorrectGreen else Color.Red
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(color),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = item.first.toString(), color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewContador() {
    Lab6Theme {
        var contador by rememberSaveable { mutableStateOf(0) }
        var incrementos by rememberSaveable { mutableStateOf(0) }
        var decrementos by rememberSaveable { mutableStateOf(0) }
        var maximo by rememberSaveable { mutableStateOf(contador) }
        var minimo by rememberSaveable { mutableStateOf(contador) }
        val historial = remember { mutableStateListOf<Pair<Int, Boolean>>() }

        Contador(
            contador = contador,
            incrementos = incrementos,
            decrementos = decrementos,
            maximo = maximo,
            minimo = minimo,
            historial = historial,
            onIncrementar = {},
            onDecrementar = {}
        )
    }
}
