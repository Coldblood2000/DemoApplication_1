package com.krushil.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.krushil.retrofit.domain.EmployeeResponse;
import com.krushil.retrofit.rest.GetDataService;
import com.krushil.retrofit.rest.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        getAllEmployees();
    }

    private void getAllEmployees(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<EmployeeResponse> call=service.getAllEmployees();
        call.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if(response.code()==200){
                    LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    EmployeeAdapter adapter=new EmployeeAdapter(MainActivity.this,response.body().getData());
                    recyclerView.setAdapter(adapter);
                    Log.i("@main","Employee=============>"+response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Log.i("@main","error=================> Sorry you are doomed!");
            }
        });
    }
}
