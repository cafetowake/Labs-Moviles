package lab6.uvg.edu.gt.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import lab6.uvg.edu.gt.ui.theme.Lab6Theme

@Composable
fun Estadisticas(modifier: Modifier = Modifier) {
    var contador by remember { mutableStateOf(0) }
    var incrementos by remember { mutableStateOf(0) }
    var decrementos by remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        Text(text = "Contador: $contador")
        Text(text = "Incrementos: $incrementos")
        Text(text = "Decrementos: $decrementos")
    }
}

@Preview
@Composable
fun PreviewEstadisticas() {
    Lab6Theme {
        Estadisticas()
    }
}
