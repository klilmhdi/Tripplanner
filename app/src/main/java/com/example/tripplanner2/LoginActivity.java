package com.example.tripplanner2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    private EditText passwordEditText;
    private Button createAccountButton;
    private TextView forgotPasswordTv;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);


        passwordEditText = findViewById(R.id.password_edit_text);
        createAccountButton = findViewById(R.id.create_account_button);
        forgotPasswordTv = findViewById(R.id.forgot_password_button);
        signInButton = findViewById(R.id.sign_in_button);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = passwordEditText.getText().toString();

                // Perform login logic here
                // ...

                // Show a success or error message to the user
                if (password.length()>7)  {
                    // Navigate to SignupActivity if the login is successful
                    Toast.makeText(getApplicationContext(), "Logged in successfully!", Toast.LENGTH_SHORT).show();
                    navigateTo(Signup.class);
                } else {
                    Toast.makeText(getApplicationContext(), "Failed: Invalid email or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to ForgotPasswordActivity
                navigateTo(ForgotPasswordActivity.class);
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to SignupActivity
                navigateTo(SignUpActivity.class);
            }
        });
    }

    // Helper method to navigate to another activity
    void navigateTo(Class<?> toClass) {
        Intent intent = new Intent(LoginActivity.this, toClass);
        startActivity(intent);
    }
}
