import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shoppingapp.R
import com.example.shoppingapp.viewmodel.ProductViewModel
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(
    navController: NavHostController,
    productViewModel: ProductViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val viewModelScope = rememberCoroutineScope()
    val context = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.bgimage),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Welcome",
            style = MaterialTheme.typography.headlineLarge,
            color = colorResource(id = R.color.custom1),
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Shopping Tracker App",
            style = MaterialTheme.typography.headlineLarge,
            color = colorResource(id = R.color.custom1),
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Email Id") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            shape = RoundedCornerShape(26.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Password") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            shape = RoundedCornerShape(26.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Sign In Button
        Button(
            onClick = {
                viewModelScope.launch {
                    val isValidCredentials = productViewModel.checkCredentials(email, password)

                    if (isValidCredentials) {
                        // navigate to the Next Home Screen
                        navController.navigate("Home_Screen")
                    } else {
                        showToast(context, "Invalid email or password")
                    }
                }
            },
            enabled = email.isNotBlank() && password.isNotBlank(),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.custom1)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Sign In")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Forgot password
        Text(
            text = "Forgot password?",
            color = colorResource(id = R.color.custom1),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .clickable { /*Handle forget password code*/ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Link to SignUp Screen
        Row {
            Text(
                text = "Don't have an account?  ",
                fontSize = 16.sp,
                modifier = Modifier
            )

            Text(
                text = "Sign Up",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.custom1),
                modifier = Modifier
                    .clickable {
                        // Handle navigation to SignUp screen here
                        navController.navigate("sign_up")
                    }
            )
        }
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}