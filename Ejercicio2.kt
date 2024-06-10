package pe.edu.idat.evaluacioncontinua1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BisiestoScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        var anio by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(
                text = "VALIDAR AÑO BISIESTO",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 30.sp,
                    color = Color.Red
                )
            )
            MySpace(espacio = 16)
            OutlinedTextField(
                value = anio,
                onValueChange = { anio = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1, singleLine = true,
                label = {
                    Text(text = "Ingrese el Año")
                }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(espacio = 16)
            Button(onClick = {
                resultado = if (esBisiesto(anio.toInt())) "El Año es Bisiesto" else "No es Bisiesto"
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "VALIDAR")
            }
            MySpace(espacio = 20)
            Text(
                text = resultado,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    fontSize = 24.sp
                )
            )
        }
    }
}

fun esBisiesto(anio: Int): Boolean {
    return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)
}