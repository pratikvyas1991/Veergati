package com.veergati.veergati.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.veergati.veergati.R;
import com.veergati.veergati.ui.MainActivity;
import com.veergati.veergati.utils.SharedPreferenceUtils;

public class LoginScreen extends AppCompatActivity {
    TextInputEditText etMobile, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etMobile = findViewById(R.id.et_mobile);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        SharedPreferenceUtils.getInstance().init(getApplicationContext());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        String mobile = etMobile.getText().toString();
        String password = etPassword.getText().toString();

        if ((!TextUtils.isEmpty(mobile)) && (!TextUtils.isEmpty(password))) {
            if(TextUtils.isDigitsOnly(mobile)){
                SharedPreferenceUtils.getInstance().setAuth(mobile);
                Toast.makeText(this, getString(R.string.success), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }else {
                Toast.makeText(this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
        }
    }
}
