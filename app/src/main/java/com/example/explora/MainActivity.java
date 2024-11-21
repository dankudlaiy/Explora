package com.example.explora;

import android.os.Bundle;
import android.util.Patterns;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputLayout emailInputLayout = findViewById(R.id.emailInputLayout);
        TextInputEditText emailEditText = findViewById(R.id.emailEditText);
        TextInputLayout passwordInputLayout = findViewById(R.id.passwordInputLayout);
        TextInputEditText passwordEditText = findViewById(R.id.passwordEditText);

        emailInputLayout.setError("Empty email");
        passwordInputLayout.setError("Empty password");

        emailEditText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String emailText = s.toString().trim();
                if (!emailText.isEmpty()) {
                    emailInputLayout.setError(null);
                } else {
                    emailInputLayout.setError("Invalid email");
                }
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {
            }
        });

        passwordEditText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwordText = s.toString().trim();
                if (!passwordText.isEmpty()) {
                    passwordInputLayout.setError(null);
                } else {
                    passwordInputLayout.setError("Invalid password");
                }
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {
            }
        });


    }

}
