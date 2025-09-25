package org.shubham.airline.components

import airline.composeapp.generated.resources.Res
import airline.composeapp.generated.resources.montserrat_medium
import airline.composeapp.generated.resources.padlock
import airline.composeapp.generated.resources.visibility
import airline.composeapp.generated.resources.visible
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.shubham.airline.ui.theme.lightGrey
import org.shubham.airline.ui.theme.white

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: DrawableResource? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true,
    isEnabled: Boolean = true,
    borderColor: Color = Color.Black,
    labelColor: Color = Color.Black   // 🌟 default: Sky Blue


) {
    val customFont = FontFamily(Font(Res.font.montserrat_medium)) // Replace with your font resource

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                fontFamily = customFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = labelColor
            )
        },
        textStyle = TextStyle(
            fontFamily = customFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        leadingIcon = leadingIcon?.let {
            { Icon(painter = painterResource(it), contentDescription = label, modifier= Modifier.size(24.dp)) }
        },

        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier.fillMaxWidth(),
        singleLine = singleLine,
        enabled = isEnabled, // ✅ Controlled by state
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = borderColor,
            unfocusedIndicatorColor = borderColor,
            cursorColor = borderColor,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )

    )
}

@Composable
fun CustomPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Password",
    modifier: Modifier = Modifier,
    iserror: Boolean,
    borderColor: Color = Color.Black,
    labelColor: Color = Color.Black   // 🌟 default: Sky Blue
) {
    var passwordVisible by remember { mutableStateOf(false) }
    val customFont = FontFamily(Font(Res.font.montserrat_medium)) // Replace with your font resource

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                fontFamily = customFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = labelColor
            )
        },
        textStyle = TextStyle(
            fontFamily = customFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        leadingIcon = { Icon(painterResource(Res.drawable.padlock), contentDescription = "Password",modifier.size(24.dp)) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val iconRes = if (passwordVisible) Res.drawable.visibility else Res.drawable.visible
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = painterResource(iconRes), contentDescription = "Toggle Password Visibility",modifier.size(24.dp))
            }
        },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        isError = iserror,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = borderColor,
            unfocusedIndicatorColor = borderColor,
            cursorColor = borderColor,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}



// common Text View & storing dynamic value
@Composable
fun CommonTextView(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    fontFamily: FontFamily = FontFamily.Default,
    style: TextStyle = TextStyle.Default // optional full style override
) {
    Text(
        text = text,
        modifier = modifier.padding(
            start = paddingStart,
            end = paddingEnd,
            top = paddingTop,
            bottom = paddingBottom
        ),
        textAlign = textAlign,

        style = style.merge(
            TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                color = color,
            )
        ),
        maxLines = maxLines,
        overflow = overflow
    )
}


@Composable
fun MyOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,

    placeholder: String,
    leadingIcon: DrawableResource,
    modifier: Modifier = Modifier,
    labelColor: Color = Color.Black   // 🌟 default: Sky Blue

) {
    val customFont = FontFamily(Font(Res.font.montserrat_medium)) // Replace with your font resource

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                fontFamily = customFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = labelColor
            )
        },
        textStyle = TextStyle(
            fontFamily = customFont,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        placeholder = { Text(placeholder) },
        leadingIcon = {
            Icon(
                painter = painterResource(leadingIcon),
                contentDescription = null,
                modifier= Modifier.size(28.dp)
            )
        },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
    )
}
