package com.krushil.appedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Bundle bundle=null;
    EditText user_id_edt,password_edt;
    Button logIn_btn;
    TextView createAccTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle=this.getIntent().getExtras();


        logIn_btn=findViewById(R.id.login_btn_main);
        createAccTxt=findViewById(R.id.createacc_txt);
        user_id_edt=findViewById(R.id.email_main_edt);
        password_edt=findViewById(R.id.pass_main_edt);

        createAccTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegistrationPage.class);
                startActivity(intent);
            }
        });

        logIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckValidation();
            }
        });
    }

    private void CheckValidation(){
        if(bundle!=null){

            if((bundle.getString("Email").equals(user_id_edt.getText().toString()) || bundle.getString("Username").equals(user_id_edt.getText().toString())) &&  bundle.getString("Password").equals(password_edt.getText().toString())){
                Intent intent=new Intent(MainActivity.this,AppViewActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this,"Invalid Account",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Invalid Account",Toast.LENGTH_LONG).show();
        }
    }
}
