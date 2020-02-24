package com.krushil.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    Bundle bundle=null;
    Button signUpBtn;

    EditText edtFirstName, edtLastName, edtEmailAdd, edtPass, edtPassCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bundle=getIntent().getExtras();
        if(bundle!=null){
            Toast.makeText(this,bundle.getString("callFrom"),Toast.LENGTH_LONG).show();
        }

        signUpBtn = findViewById(R.id.signup_btn);
        edtFirstName=findViewById(R.id.first_name_edt);
        edtLastName=findViewById(R.id.last_name_edt);
        edtEmailAdd=findViewById(R.id.email_edt);
        edtPass=findViewById(R.id.pass_edt);
        edtPassCon=findViewById(R.id.pass_con_edt);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void CheckValidations(){
        if(edtFirstName.getText().toString().isEmpty()){
            Toast.makeText(this,bundle.getString("Enter first name"),Toast.LENGTH_LONG).show();
        }
        else if(edtLastName.getText().toString().isEmpty()){
            Toast.makeText(this,bundle.getString("Enter last name"),Toast.LENGTH_LONG).show();
        }
        else if(edtEmailAdd.getText().toString().isEmpty()){
            Toast.makeText(this,bundle.getString("Enter email address"),Toast.LENGTH_LONG).show();
        }
        else if(edtPass.getText().toString().length()<6){
            Toast.makeText(this,bundle.getString("Enter valid password"),Toast.LENGTH_LONG).show();
        }
        else if(edtPassCon.getText().toString().equals(edtPass.getText().toString())){
            Toast.makeText(this,bundle.getString("Entered password is not equal to the above entered password."),Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(RegistrationActivity.this,Dashboard.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
        }
    }
}
