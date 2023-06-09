package kau.brave.breakthecycle.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kau.brave.breakthecycle.R
import kau.brave.breakthecycle.theme.ErrorColor
import kau.brave.breakthecycle.theme.Gray300
import kau.brave.breakthecycle.theme.Gray600
import kau.brave.breakthecycle.theme.Main
import kau.brave.breakthecycle.utils.bottomBorder

/**
 * @param onErrorState 해당 값이 true라면 밑줄이 색이 빨개지고, 에러 메시지를 출력한다.
 * @param onFocuseChange 포커스 값을 외부에서 관찰할 때 사용
 */
@Composable
fun CustomTextField(
    value: String,
    onvalueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    placeholderText: String = "",
    fontSize: TextUnit = 16.sp,
    focusRequest: FocusRequester? = null,
    keyboardOptions: KeyboardOptions? = null,
    keyboardActions: KeyboardActions? = null,
    onFocuseChange: (Boolean) -> Unit = {},
    onErrorState: Boolean = false,
    maxSize: Int = 25,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMessage: String = "",
) {
    val bottomLineColor = remember {
        mutableStateOf(Gray600)
    }
    Column(modifier = modifier) {
        BasicTextField(
            modifier = Modifier
                .bottomBorder(1.dp, Gray300)
                .onFocusChanged {
                    onFocuseChange(it.isFocused)
                    if (it.isFocused) {
                        bottomLineColor.value = Color.Black
                    } else {
                        bottomLineColor.value = Gray300
                    }
                }
                .bottomBorder(1.dp, if (onErrorState) ErrorColor else bottomLineColor.value)
                .focusRequester(focusRequest ?: FocusRequester()),
            value = value,
            onValueChange = {
                if (it.length <= maxSize) onvalueChanged(it)
            },
            singleLine = true,
            cursorBrush = SolidColor(Main),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = fontSize,
            ),
            keyboardOptions = keyboardOptions ?: KeyboardOptions(),
            keyboardActions = keyboardActions ?: KeyboardActions(),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(0.dp, 10.dp)
                ) {
                    if (leadingIcon != null) leadingIcon()
                    Box(Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                placeholderText,
                                style = LocalTextStyle.current.copy(
                                    color = Color.Black.copy(alpha = 0.3f),
                                    fontSize = fontSize,
                                ),
                            )
                        }
                        innerTextField()
                    }
                    if (value.isNotBlank()) {
                        IconButton(
                            onClick = { onvalueChanged("") },
                            modifier = Modifier.size(16.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_close_24),
                                contentDescription = "IC_CLOSE"
                            )
                        }
                    }
                    if (trailingIcon != null) trailingIcon()
                }
            },
            visualTransformation = visualTransformation,
        )
//        if (onErrorState && errorMessage.isNotBlank())  ErrorMessage(message = errorMessage)
    }
}