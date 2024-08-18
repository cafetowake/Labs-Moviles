package lab6.uvg.edu.gt.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lab6.uvg.edu.gt.ui.theme.Lab6Theme

@Composable
fun BotonReiniciar(onReiniciar: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onReiniciar,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "Reiniciar")
    }
}

@Preview
@Composable
fun PreviewBotonReiniciar() {
    Lab6Theme {
        BotonReiniciar(onReiniciar = {})
    }
}
