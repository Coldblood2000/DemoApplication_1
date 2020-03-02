package com.krushil.appedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    EditText email_edt,username_edt,pass_edt,conpass_edt;
    Button create_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        email_edt=findViewById(R.id.email_reg_edt);
        username_edt=findViewById(R.id.username_reg_edt);
        pass_edt=findViewById(R.id.pass_reg_edt);
        conpass_edt=findViewById(R.id.con_pass_reg_edt);
        create_btn=findViewById(R.id.create_reg_btn);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckValidation();
            }
        });
    }

    private void CheckValidation(){
        if(email_edt.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter Email Id",Toast.LENGTH_SHORT).show();
        }
        else if(username_edt.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter Username",Toast.LENGTH_SHORT).show();
        }
        else if(pass_edt.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show();
        }
        else if(conpass_edt.getText().toString().isEmpty()){
            Toast.makeText(this,"Confirm Password",Toast.LENGTH_SHORT).show();
        }
        else if(!pass_edt.getText().toString().equals(conpass_edt.getText().toString())){
            Toast.makeText(this,"Entered Password Not Matching",Toast.LENGTH_SHORT).show();
        }
        else{
            Bundle bundle=new Bundle();
            bundle.putString("Email",email_edt.getText().toString());
            bundle.putString("Username",username_edt.getText().toString());
            bundle.putString("Password",pass_edt.getText().toString());

            Intent intent=new Intent(RegistrationPage.this,MainActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
