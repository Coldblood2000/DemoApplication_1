package com.krushil.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button frag_1_Btn;
    Button frag_2_Btn;
    Button frag_3_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_1_Btn=findViewById(R.id.frag_1_Btn);
        frag_2_Btn=findViewById(R.id.frag_2_Btn);
        frag_3_Btn=findViewById(R.id.frag_3_Btn);

        frag_1_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment fragment=new BlankFragment();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.frame_container,fragment);
                fragmentTransaction.commit();
            }
        });

        frag_2_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment2 fragment=new BlankFragment2();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.frame_container,fragment);
                fragmentTransaction.commit();
            }
        });

        frag_3_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment3 fragment=new BlankFragment3();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.frame_container,fragment);
                fragmentTransaction.commit();
            }
        });
    }
}
