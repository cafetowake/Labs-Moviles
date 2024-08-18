package lab6.uvg.edu.gt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import lab6.uvg.edu.gt.componentes.BotonReiniciar
import lab6.uvg.edu.gt.componentes.Contador
import lab6.uvg.edu.gt.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                var contador by rememberSaveable { mutableStateOf(0) }
                var incrementos by rememberSaveable { mutableStateOf(0) }
                var decrementos by rememberSaveable { mutableStateOf(0) }
                var maximo by rememberSaveable { mutableStateOf(0) }
                var minimo by rememberSaveable { mutableStateOf(0) }
                val historial = remember { mutableStateListOf<Pair<Int, Boolean>>() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BotonReiniciar(
                            onReiniciar = {
                                contador = 0
                                incrementos = 0
                                decrementos = 0
                                maximo = 0
                                minimo = 0
                                historial.clear()
                            }
                        )
                    }
                ) { innerPadding ->
                    Contador(
                        contador = contador,
                        incrementos = incrementos,
                        decrementos = decrementos,
                        maximo = maximo,
                        minimo = minimo,
                        historial = historial,
                        onIncrementar = {
                            contador++
                            incrementos++
                            if (contador > maximo) maximo = contador
                            historial.add(Pair(contador, true))
                        },
                        onDecrementar = {
                            contador--
                            decrementos++
                            if (contador < minimo) minimo = contador
                            historial.add(Pair(contador, false))
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

