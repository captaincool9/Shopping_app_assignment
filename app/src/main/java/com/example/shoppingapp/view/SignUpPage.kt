package com.example.shoppingapp.view

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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.shoppingapp.R
import com.example.shoppingapp.viewmodel.ProductViewModel


@Composable
fun SignUpScreen(
    navController: NavHostController,
    productViewModel: ProductViewModel = viewModel()
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var isRememberMeChecked by remember { mutableStateOf(false) }

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
        Spacer(modifier = Modifier.height(210.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.Center, // Center horizontally
        ) {

            Text(
                text = "Create Your Account",
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(id = R.color.custom1),
                fontWeight = FontWeight.ExtraBold
            )
        }
        // First Name Field
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            label = { Text("First Name") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(26.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        )

        // Last Name Field
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            label = { Text("Last Name") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1,
            shape = RoundedCornerShape(26.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        )

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            label = { Text("Email Id") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            shape = RoundedCornerShape(26.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
        )

        // Address Field
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            label = { Text("Address") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            shape = RoundedCornerShape(26.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            label = { Text("Password") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            shape = RoundedCornerShape(26.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
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

        // Date of Birth Field
        OutlinedTextField(
            value = dob,
            onValueChange = { dob = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Date of Birth") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0093DA),
                unfocusedBorderColor = Color(0xFF0093DA),
            ),
            shape = RoundedCornerShape(26.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
        )
        // Remember Me Checkbox
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = isRememberMeChecked,
                onCheckedChange = { isRememberMeChecked = it },
                modifier = Modifier.size(24.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(id = R.color.custom1), // Custom color when checked
                    uncheckedColor = colorResource(id = R.color.custom1) // Custom color when unchecked
                )
            )

            Text("I Agree to all Terms & Conditions")
        }

        // SignUp Button
        Button(
            onClick = {
                productViewModel.addUser(firstName, lastName, email, address, password, dob)
            },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.custom1)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // SignIn Button
        Row {
            Text(
                text = "Already have an account?  ",
                fontSize = 16.sp,
                modifier = Modifier
            )

            Text(
                text = "Sign In",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.custom1),
                modifier = Modifier
                    .clickable {
                        navController.navigate("sign_in")

                    }
            )
        }
    }
}