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
fun AprobacionScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        var nota1 by rememberSaveable {
            mutableStateOf("")
        }
        var nota2 by rememberSaveable {
            mutableStateOf("")
        }
        var nota3 by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(
                text = "VALIDAR APROBACION",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            )
            MySpace(espacio = 25)
            OutlinedTextField(
                value = nota1,
                onValueChange = { nota1 = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1, singleLine = true,
                label = { Text(text = "Ingrese Nota Nº 1") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(espacio = 16)
            OutlinedTextField(
                value = nota2,
                onValueChange = { nota2 = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1, singleLine = true,
                label = { Text(text = "Ingrese Nota Nº 2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(espacio = 16)
            OutlinedTextField(
                value = nota3,
                onValueChange = { nota3 = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1, singleLine = true,
                label = {
                    Text(text = "Ingrese Nota Nº 3")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(espacio = 20)
            Button(onClick = {
                resultado = calcularAprobacion(nota1.toDouble(), nota2.toDouble(), nota3.toDouble())
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

fun calcularAprobacion(nota1: Double, nota2: Double, nota3: Double): String {
    val promedio = (nota1 + nota2 + nota3) / 3.0
    return if (promedio >= 70) {
        "APROBADO con promedio %.2f".format(promedio)
    } else {
        "REPROBADO con promedio %.2f".format(promedio)
    }
}