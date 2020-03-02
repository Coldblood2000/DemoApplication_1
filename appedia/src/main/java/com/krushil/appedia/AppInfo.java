package com.krushil.appedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AppInfo extends AppCompatActivity {

    TextView infoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        infoTxt = findViewById(R.id.info_txt);
        Bundle bundle = getIntent().getExtras();
        Info(bundle.getString("info"));
    }

    private void Info(String val){
        if(val.equals("Google plus")){
            infoTxt.setText("This is google plus developed by google.");
        }
        else if(val.equals("Instagram")){
            infoTxt.setText("This is instagram developed using django a python framework. Owned by facebook.");
        }
        else if(val.equals("Pinterest")){
            infoTxt.setText("This is pinterest don't know what it is...");
        }
        else if(val.equals("Snapchat")){
            infoTxt.setText("This is snapchat developed by a very arrogant man");
        }
        else if(val.equals("Twitter")){
            infoTxt.setText("This is twitter popular among celebrities");
        }
        else if(val.equals("Whatsapp")){
            infoTxt.setText("This is whatsapp owned by facebook");
        } else if (val.equals("Youtube")) {

            infoTxt.setText("This is youtube a avery popular streaming application owned by google");
        }
    }
}
