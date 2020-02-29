package com.krushil.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.krushil.localstorage.prefs.Prefs;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtUsername;
    Button btnSave, btnGet;
    TextView txtSavedMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName=findViewById(R.id.name_edt);
        edtUsername=findViewById(R.id.username_edt);
        btnSave=findViewById(R.id.save_btn);
        btnGet =findViewById(R.id.get_btn);
        txtSavedMsg=findViewById(R.id.saved_txt);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckValidation();
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowSavedData();
            }
        });
    }

    private void CheckValidation(){
        if(edtName.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter name -- Chaman", Toast.LENGTH_SHORT).show();
        }
        else if(edtUsername.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter username -- Chicken chore", Toast.LENGTH_SHORT).show();
        }
        else{
            saveData();
        }
    }

    private void saveData(){
        Prefs.saveEmployeeName(MainActivity.this,edtName.getText().toString());
        Prefs.saveEmployeeUsername(MainActivity.this,edtUsername.getText().toString());
    }

    private void ShowSavedData(){
        txtSavedMsg.setText(Prefs.getEmployeeName(MainActivity.this)+"\n"+Prefs.getEmployeeUsename(MainActivity.this));
    }
}
