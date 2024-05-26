package com.tmpsolutions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tmpsolutions.R
import com.tmpsolutions.ui.navigation.Screen


const val fillPercent = .9f

@Preview(showBackground = true)
@Composable
fun LoginScreen(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_background)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopCircles()

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Cadastro",
            fontSize = 20.sp,
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .padding(vertical = 20.dp)
        )

        InputData(value = "nome", onValueChange = {})
        InputData(value = "E-mail", onValueChange = {})
        InputData(value = "Senha", onValueChange = {})
        InputData(value = "Senha Conf.", onValueChange = {})

        NextStepButton(
            text = "Registrar",
            onClick = { /*TODO*/ },
            color = colorResource(id = R.color.user_area_background)
        )

        NextStepButton(
            text = "Entrar pelo Google",
            onClick = { /*TODO*/ },
            color = colorResource(id = R.color.btn_red)
        )

        NextStepButton(
            text = "Entrar sem login",
            onClick = {
                navController?.navigate(Screen.MainScreen.route)
            },
            color = colorResource(id = R.color.btn_gray)
        )

        Row (
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 30.dp),
            verticalAlignment = Alignment.Bottom){
            Text(
                text = "Ja tem uma conta?",
                fontSize = 16.sp
            )
            Text(
                text = "Entrar",
                color = colorResource(id = R.color.user_area_background),
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun InputData(value: String, onValueChange: (String) -> Unit) {
    val height = 50.dp
    TextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = MaterialTheme
            .shapes.
            small.copy(
                topEnd = CornerSize(height / 2),
                topStart = CornerSize(height / 2),
                bottomEnd = CornerSize(height / 2),
                bottomStart = CornerSize(height / 2)),
        modifier = Modifier
            .padding(vertical = 15.dp)
            .height(height)
            .fillMaxWidth(fillPercent)
    )
}

@Composable
fun NextStepButton(text: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(fillPercent)
            .padding(vertical = 8.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        elevation = ButtonDefaults.elevation(3.dp)
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.aquarium_card_background),
            fontSize = 15.sp
        )
    }
}