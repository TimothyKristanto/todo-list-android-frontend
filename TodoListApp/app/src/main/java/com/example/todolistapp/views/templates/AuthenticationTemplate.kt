package com.example.todolistapp.views.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.R

@Composable
fun GeneralOutlinedTextField(
    inputValue: String,
    onInputValueChange: (String) -> Unit,
    labelText: String,
    placeholderText: String,
    leadingIconSrc: Painter,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardOptions,
    onKeyboardNext: KeyboardActions
) {
    OutlinedTextField(
        value = inputValue,
        onValueChange = onInputValueChange,
        singleLine = true,
        label = {
            Text(
                text = labelText
            )
        },
        placeholder = {
            Text(
                text = placeholderText
            )
        },
        modifier = modifier,
        shape = RoundedCornerShape(size = 15.dp),
        leadingIcon = {
            Image(
                painter = leadingIconSrc,
                contentDescription = null
            )
        },
        keyboardOptions = keyboardType,
        keyboardActions = onKeyboardNext
    )
}

@Composable
fun PasswordOutlinedTextField(
    passwordInput: String,
    onPasswordInputValueChange: (String) -> Unit,
    passwordVisibilityIcon: Painter,
    labelText: String,
    placeholderText: String,
    onTrailingIconClick: () -> Unit,
    passwordVisibility: VisualTransformation,
    modifier: Modifier = Modifier,
    onKeyboardNext: KeyboardActions,
    keyboardImeAction: ImeAction
) {
    OutlinedTextField(
        value = passwordInput,
        onValueChange = onPasswordInputValueChange,
        singleLine = true,
        label = {
            Text(
                text = labelText
            )
        },
        trailingIcon = {
            Image(
                painter = passwordVisibilityIcon,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onTrailingIconClick()
                    }
            )
        },
        placeholder = {
            Text(
                text = placeholderText
            )
        },
        visualTransformation = passwordVisibility,
        modifier = modifier,
        shape = RoundedCornerShape(size = 15.dp),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = keyboardImeAction
        ),
        keyboardActions = onKeyboardNext
    )
}

@Composable
fun AuthenticationButton(
    buttonText: String,
    onButtonClick: () -> Unit,
    buttonModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        modifier = buttonModifier,
        colors = ButtonDefaults.buttonColors(Color.Blue)
    ) {
        Text(
            text = buttonText,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = textModifier
        )
    }
}

@Composable
fun AuthenticationQuestion(
    questionText: String,
    actionText: String,
    rowModifier: Modifier = Modifier,
    onActionTextClicked: () -> Unit,
) {
    Row(
        modifier = rowModifier
    ) {
        Text(
            text = questionText
        )

        Text(
            text = actionText,
            color = Color.Blue,
            modifier = Modifier
                .clickable {
                    onActionTextClicked()
                }
        )
    }
}