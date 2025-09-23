package org.example.jetshop.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val OTP_VIEW_TYPE_NONE = 0
const val OTP_VIEW_TYPE_UNDERLINE = 1
const val OTP_VIEW_TYPE_BORDER = 2



@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    otpText: String = "",
    charColor: Color = Color(0XFFE8E8E8),
    charBackground: Color = Color.Transparent,
    charSize: TextUnit = 20.sp,
    containerSize: Dp = charSize.value.dp * 2,
    otpCount: Int = 4,
    type: Int = OTP_VIEW_TYPE_BORDER,
    enabled: Boolean = true,
    password: Boolean = false,
    passwordChar: String = "*",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
    onOtpTextChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= otpCount) {
                onOtpTextChange.invoke(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center),
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpCount) { index ->
                    Spacer(modifier = Modifier.width(2.dp))
                    CharView(
                        index = index,
                        text = otpText,
                        charColor = charColor,
                        charSize = charSize,
                        containerSize = containerSize,
                        type = type,
                        charBackground = charBackground,
                        password = password,
                        passwordChar = passwordChar,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    charColor: Color,
    charSize: TextUnit,
    containerSize: Dp,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String = "*"
) {
    val char = when {
        index >= text.length -> ""
        password -> passwordChar
        else -> text[index].toString()
    }

    val boxModifier = if (type == OTP_VIEW_TYPE_BORDER) {
        Modifier
            .size(containerSize)
            .border(
                width = 1.dp,
                color = charColor,
                shape = RoundedCornerShape(5.dp)
            )
            .background(charBackground)
    } else Modifier
        .width(containerSize)
        .background(charBackground)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = char,
            color = Color.Black,
            fontSize = charSize,
            textAlign = TextAlign.Center,
            modifier = boxModifier
                .wrapContentHeight()
                .padding(4.dp)
        )

        if (type == OTP_VIEW_TYPE_UNDERLINE) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(charColor)
                    .height(1.dp)
                    .width(containerSize)
            )
        }
    }
}

@Composable
fun OTPInputField(
    value: String,
    focusRequester: FocusRequester,
    onValueChange: (String) -> Unit
) { OutlinedTextField(
    value = value,
    onValueChange = { text ->
        if (text.length <= 1) { // Only allow 1 character
            onValueChange(text)
        }
    },
    modifier = Modifier
        .size(50.dp)
        .focusRequester(focusRequester)
        .clip(RoundedCornerShape(8.dp)),
    textStyle = TextStyle(
        fontSize = 18.sp,
        textAlign = TextAlign.Center // Center the text inside the field
    ),
    keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.NumberPassword
    ),
    singleLine = true,
    maxLines = 1,
    visualTransformation = VisualTransformation.None,
    shape = RoundedCornerShape(10.dp),
    colors = OutlinedTextFieldDefaults.colors( // Use this for Material 3
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        cursorColor = MaterialTheme.colorScheme.primary
    )
)}
@Composable
fun PreviewOTPTexField() {
    val focusRequester = remember { FocusRequester() }
    var otp by remember { mutableStateOf("") }
    Row   {

        OTPInputField(
            value = otp,
            focusRequester = focusRequester,
            onValueChange = { otp = it }
        )
        OTPInputField(
            value = otp,
            focusRequester = focusRequester,
            onValueChange = { otp = it }
        )
    }
}