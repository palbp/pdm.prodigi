package prodigi.pdm.demos.compose.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import prodigi.pdm.demos.compose.ui.theme.ComposeExamplesTheme

@Composable
fun LoginForm(
    loading: Boolean,
    error: String?,
    onLogin: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isDataValid = email.isValidEmail() && password.isNotBlank()
    LoginFormStateless(
        loading = loading,
        error = error,
        email = email,
        password = password,
        isDataValid = isDataValid,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onLogin = onLogin,
        modifier
    )
}

@Composable
fun LoginFormStateless(
    loading: Boolean,
    error: String?,
    email: String,
    password: String,
    isDataValid: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { if (isDataValid && !loading) onLogin(email, password) }),
            modifier = Modifier.fillMaxWidth()
        )

        if (!error.isNullOrBlank()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        Button(
            onClick = { onLogin(email, password) },
            enabled = isDataValid && !loading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (loading) {
                CircularProgressIndicator(Modifier.size(16.dp), strokeWidth = 2.dp)
                Spacer(Modifier.width(8.dp))
            }
            Text("Entrar")
        }
    }
}

// helpers
private fun String.isValidEmail(): Boolean =
    isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

@Preview(showBackground = true)
@Composable
fun LoginFormInvalidDataPreview() {
    ComposeExamplesTheme {
        LoginFormStateless(
            loading = false,
            error = null,
            email = "paulo.pereira@isel.pt",
            password = "",
            isDataValid = false,
            onEmailChange = {},
            onPasswordChange = {},
            onLogin = { _, _ -> }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormValidDataPreview() {
    ComposeExamplesTheme {
        LoginFormStateless(
            loading = false,
            error = null,
            email = "paulo.pereira@isel.pt",
            password = "thePassword",
            isDataValid = true,
            onEmailChange = { },
            onPasswordChange = { },
            onLogin = { _, _ -> }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormSubmittingPreview() {
    ComposeExamplesTheme {
        LoginFormStateless(
            loading = true,
            error = null,
            email = "paulo.pereira@isel.pt",
            password = "thePassword",
            isDataValid = true,
            onEmailChange = { },
            onPasswordChange = { },
            onLogin = { _, _ -> }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreviewError() {
    ComposeExamplesTheme {
        LoginFormStateless(
            loading = false,
            error = "Failed to authenticate",
            email = "",
            password = "",
            isDataValid = false,
            onEmailChange = {},
            onPasswordChange = {},
            onLogin = { _, _ -> }
        )
    }
}
