package com.example.tripplanner2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText mEmailEditText;
    private Button mResetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_layout);

        mEmailEditText = findViewById(R.id.email_edit_text);
        mResetPasswordButton = findViewById(R.id.reset_password_button);

        mResetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailEditText.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    mEmailEditText.setError("Please enter email");
                    return;
                }
                if (!isValidEmail(email)) {
                    mEmailEditText.setError("Please enter valid email");
                    return;
                }

                // Perform reset password operation
                Toast.makeText(ForgotPasswordActivity.this, "Password reset link sent to your email", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
