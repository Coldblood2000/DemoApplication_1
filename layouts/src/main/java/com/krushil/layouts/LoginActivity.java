package com.krushil.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button signUp;
    Button btnLogin;
    Button activity3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        signUp=findViewById(R.id.btnSignup);
        btnLogin=findViewById(R.id.btnLogin);
        activity3Btn=findViewById(R.id.li_btn);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putString("callFrom","login");

                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        activity3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
