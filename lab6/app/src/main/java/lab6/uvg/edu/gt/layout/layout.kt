package lab6.uvg.edu.gt.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab6.uvg.edu.gt.componentes.Contador
import lab6.uvg.edu.gt.componentes.Estadisticas
import lab6.uvg.edu.gt.componentes.Historial
import lab6.uvg.edu.gt.ui.theme.Lab6Theme

@Composable
fun PantallaPrincipal(
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

        Spacer(modifier = Modifier.height(16.dp))

        Contador(
            contador = contador,
            incrementos = incrementos,
            decrementos = decrementos,
            maximo = maximo,
            minimo = minimo,
            historial = historial,
            onIncrementar = onIncrementar,
            onDecrementar = onDecrementar
        )

        Spacer(modifier = Modifier.height(16.dp))

        Estadisticas()

        Spacer(modifier = Modifier.height(16.dp))

        Historial()
    }
}

@Preview
@Composable
fun PreviewPantallaPrincipal() {
    Lab6Theme {
        var contador by rememberSaveable { mutableStateOf(0) }
        var incrementos by rememberSaveable { mutableStateOf(0) }
        var decrementos by rememberSaveable { mutableStateOf(0) }
        var maximo by rememberSaveable { mutableStateOf(contador) }
        var minimo by rememberSaveable { mutableStateOf(contador) }
        val historial = remember { mutableStateListOf<Pair<Int, Boolean>>() }

        PantallaPrincipal(
            contador = contador,
            incrementos = incrementos,
            decrementos = decrementos,
            maximo = maximo,
            minimo = minimo,
            historial = historial,
            onIncrementar = { /* Lógica para incrementar */ },
            onDecrementar = { /* Lógica para decrementar */ }
        )
    }
}
