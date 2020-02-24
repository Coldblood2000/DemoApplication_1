package com.krushil.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        signUpBtn = findViewById(R.id.ma3_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putString("callFrom","Main3Activity");

                Intent intent=new Intent(Main3Activity.this,RegistrationActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
