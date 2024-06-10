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
fun PerfectoScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        var limite by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(
                text = "VALIDAR NUMEROS PERFECTOS",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Magenta,
                    fontSize = 30.sp
                )
            )
            MySpace(espacio = 24)
            OutlinedTextField(
                value = limite,
                onValueChange = { limite = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese un numero") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(espacio = 16)
            Button(
                onClick = { resultado = validarNumeroPerfecto(limite.toInt()) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "VALIDAR")
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

fun validarNumeroPerfecto(limite: Int): String {
    val numerosPerfectos = mutableListOf<Int>()
    for (numero in 1..limite) {
        if (esPerfecto(numero)) {
            numerosPerfectos.add(numero)
        }
    }
    return "Numeros Perfectos hasta $limite: ${numerosPerfectos.joinToString(", ")}"
}
fun esPerfecto(numero:Int):Boolean{
    val sumaDivisores = (1..numero/2).filter { numero%it==0 }.sum()
    return sumaDivisores==numero
}
