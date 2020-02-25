package com.krushil.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] images;
    String[] names;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        images=new int[]{R.drawable.googleplus,R.drawable.instagram,R.drawable.pinterest,R.drawable.snapchat,R.drawable.twitter,R.drawable.whatsapp,R.drawable.youtube};
        names=new String[]{"Google plus", "Instagram", "Pinterest","Snapchat","Twitter","Whatsapp","Youtube"};

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager((MainActivity.this));
        AppAdapter adapter=new AppAdapter(MainActivity.this, getList(images,names));

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<AppAndroid> getList(int[] images,String[] names){
        List<AppAndroid> list=new ArrayList<>();
        for(int i=0;i<images.length;i++){
            AppAndroid appAndroid=new AppAndroid();
            appAndroid.setImage(images[i]);
            appAndroid.setName(names[i]);
            list.add(appAndroid);
        }
        return list;
    }
}
