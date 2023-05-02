package com.example.tripplanner2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText passwordEditText;
    private EditText passwordVerificationEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity_layout);

        emailEditText = findViewById(R.id.name_edit_text);
        phoneEditText = findViewById(R.id.phone_number_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        passwordVerificationEditText = findViewById(R.id.password_verification_edit_text);
        Button createAccountButton = findViewById(R.id.create_account_button);

        createAccountButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String passwordVerification = passwordVerificationEditText.getText().toString();


            if (!isValidPhone(phone)) {
                phoneEditText.setError("Invalid phone number");
                return;
            }

            if (password.length() < 8) {
                passwordEditText.setError("Password must be at least 8 characters long");
                return;
            }

            if (!password.equals(passwordVerification)) {
                passwordVerificationEditText.setError("Passwords do not match");
                return;
            }

            // Account creation logic here
            // ...

            Toast.makeText(this.getApplicationContext(), "Account created successfully!", Toast.LENGTH_SHORT).show();
        });
    }


    private boolean isValidPhone(String phone) {
        return phone.length() > 7;
    }
}