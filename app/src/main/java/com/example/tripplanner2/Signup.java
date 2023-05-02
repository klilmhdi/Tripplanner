package com.example.tripplanner2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    private Button submitButton;
    private EditText emailEditText;
    private CheckBox backpackerCheckbox;
    private CheckBox coupleCheckbox;
    private CheckBox familyCheckbox;
    private CheckBox groupCheckbox;
    private CheckBox businessCheckbox;
    private TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Find views by their IDs
        submitButton = findViewById(R.id.submit_button);
        emailEditText = findViewById(R.id.email_edit_text);
        backpackerCheckbox = findViewById(R.id.backpacker_checkbox);
        coupleCheckbox = findViewById(R.id.couple_checkbox);
        familyCheckbox = findViewById(R.id.family_checkbox);
        groupCheckbox = findViewById(R.id.group_checkbox);
        businessCheckbox = findViewById(R.id.business_checkbox);
        skip = findViewById(R.id.skipTv);
        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a new intent to launch the CreateTripActivity
                Intent intent = new Intent(Signup.this, createTripActivity.class);

                // Add the user's travel style to the intent as a string
                if (backpackerCheckbox.isChecked()) {
                    intent.putExtra("travelStyle", "Backpacker");
                } else if (coupleCheckbox.isChecked()) {
                    intent.putExtra("travelStyle", "Couple");
                } else if (familyCheckbox.isChecked()) {
                    intent.putExtra("travelStyle", "Family");
                } else if (groupCheckbox.isChecked()) {
                    intent.putExtra("travelStyle", "Group");
                } else if (businessCheckbox.isChecked()) {
                    intent.putExtra("travelStyle", "Business");
                } else {
                    String otherStyle = emailEditText.getText().toString();
                    if (otherStyle.trim().isEmpty()) {
                        otherStyle = "Unknown";
                    }
                    intent.putExtra("travelStyle", otherStyle);
                }

                // Launch the CreateTripActivity
                startActivity(intent);
            }
        });

        // Set a click listener for the skip button
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, createTripActivity.class);
                startActivity(intent);
            }
        });
    }
}
