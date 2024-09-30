package com.codebly.zibro.view.login;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.codebly.zibro.R;
import com.codebly.zibro.databinding.ActivitySignupBinding;
import com.codebly.zibro.ui.login.LoginViewModel;
import com.codebly.zibro.ui.login.LoginViewModelFactory;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignupBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        // ui요소 정의
        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final EditText confirmpasswordEditText = binding.confirmpassword;
        final ImageView signUpButton = binding.signup;
        final ProgressBar loadingProgressBar; // TODO
    }
}