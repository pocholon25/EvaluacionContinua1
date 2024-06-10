package pe.edu.idat.evaluacioncontinua1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun AlmacenScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        var precioUnitario by rememberSaveable { mutableStateOf("") }
        var cantidad by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CALCULAR PRECIO FINAL",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Red
                )
            )
            MySpace(16)
            OutlinedTextField(
                value = precioUnitario,
                onValueChange = { precioUnitario = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1, singleLine = true,
                label = { Text(text = "Ingrese precio Unitario") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(
                value = cantidad,
                onValueChange = { cantidad = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1, singleLine = true,
                label = { Text(text = "Ingrese Cantidad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(espacio = 20)
            Button(onClick = {
                resultado = calcularPrecioFinal(precioUnitario.toDouble(), cantidad.toInt())
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace(espacio = 16)
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

@Composable
fun MySpace(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun calcularPrecioFinal(precioUnitario: Double, cantidad: Int): String {
    val descuento = when {
        cantidad > 20 -> 0.10
        cantidad in 11..20 -> 0.05
        else -> 0.0
    }
    val precioFinal = precioUnitario * cantidad * (1 - descuento)
    return "El precio final es:  %.2f".format(precioFinal)
}