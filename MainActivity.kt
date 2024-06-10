package pe.edu.idat.evaluacioncontinua1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.evaluacioncontinua1.ui.theme.EvaluacionContinua1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvaluacionContinua1Theme {
               Navigation()
            }
        }
    }
}
@Composable
fun Navigation(){
    var screen by rememberSaveable {
        mutableStateOf("Ejercicio Nº 1")
    }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = {screen = "Almacen"},
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = "Ejercicio Nº 1")
        }
        Button(
            onClick = {screen = "Bisiesto"},
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = "Ejercicio Nº 2")
        }
        Button(
            onClick = {screen = "Aprobacion"},
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = "Ejercicio Nº 3")
        }
        Button(
            onClick = {screen = "Perfecto"},
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = "Ejercicio Nº 4")
        }
        when (screen){
            "Almacen" -> AlmacenScreen()
            "Bisiesto" -> BisiestoScreen()
            "Aprobacion" -> AprobacionScreen()
            "Perfecto" -> PerfectoScreen()
        }
    }
}



