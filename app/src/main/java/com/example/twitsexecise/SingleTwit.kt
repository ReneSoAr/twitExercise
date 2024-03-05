package com.example.twitsexecise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TwitBody() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFF171C28)
            )
    ) {
        ProfileImg()
        TwitContent()
    }
}

@Composable
fun TwitContent() {

    var chat by remember { mutableStateOf(false) }
    var retwit by remember { mutableStateOf(false) }
    var like by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            TextTitle(userName = "Aris")
            genericText(genericText = "@AristiDev")
            genericText(genericText = "4h")
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "",
                tint = Color(0xFF51565F),
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        Spacer(modifier = Modifier.size(8.dp))
        genericText(
            genericText = "Es un hecho establecido hace demasiado " +
                    "tiempo que un lector se distraerá con el " +
                    "contenido del texto de un " +
                    "sitio mientras que mira su diseño"
        )
        Spacer(modifier = Modifier.size(8.dp))
        Image(
            painter = painterResource(
                id = R.drawable.profile
            ),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,

            )

        Row(modifier = Modifier.padding(top = 16.dp)) {
            SocialIcon(
                modifier = Modifier.weight(1f),//asi cada elemento va a ocupar un mismo tamaño o se va a distribuir el tamaño de forma equvalente
                unselectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat),
                        contentDescription = "",
                        tint = Color(0xFF6B747E)
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat_filled),
                        contentDescription = "",
                        tint = Color(0xFF6B747E)
                    )
                },
                isSelected = chat//al parametro is selected se le asigna el valor del estado chat
            ) {
                chat = !chat
            }

            SocialIcon(
                modifier = Modifier.weight(1f),
                unselectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "",
                        tint = Color(0xFF6B747E)
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "",
                        tint = Color.Green
                    )
                },
                isSelected = retwit
            ) {
                retwit = !retwit

            }
            SocialIcon(
                modifier = Modifier.weight(1f),
                unselectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = "",
                        tint = Color(0xFF6B747E)
                    )
                },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like_filled),
                        contentDescription = "",
                        tint = Color.Red
                    )
                },
                isSelected = like
            ) {
                like =!like
            }

        }

    }
}


@Composable
fun SocialIcon(
    modifier: Modifier, // para pasar modificadores del padre como argumento
    unselectedIcon: @Composable () -> Unit,// se usara para crear un composable de icono sin seleccionar
    selectedIcon: @Composable () -> Unit,// se usara para crear un composable de icono seleccionado
    isSelected: Boolean,// se usará pasa saber si esta seleccionado o no el icono
    onItemSelected: () -> Unit// se usara para cambiar el valor del estado
) {

    var defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },// la fila es cliqueable y al clikear se llama a la funcion onItemSelected
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {//cuando el parametro is selected sea igualado al estado este tendra un valor true o false
            selectedIcon()
        } else {
            unselectedIcon()
        }
    }

    Text(text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString())

}

@Composable
fun genericText(genericText: String) {
    Text(
        text = genericText,
        color = Color(0xFF51565F),
        modifier = Modifier.padding(end = 8.dp)
    )
}

@Composable
fun TextTitle(userName: String) {
    Text(
        text = userName,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.padding(end = 8.dp)
    )
}


@Composable
fun ProfileImg() {
    Image(
        painter = painterResource(id = R.drawable.profile), contentDescription = "",
        modifier = Modifier
            .padding(12.dp)
            .size(70.dp)
            .clip(CircleShape)

    )
}
