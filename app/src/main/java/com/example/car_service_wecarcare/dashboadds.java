package com.example.car_service_wecarcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboadds extends AppCompatActivity {


    Button btnloaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboadds);


        btnloaner=(Button)findViewById(R.id.loaner);
        btnloaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DsMainActivity.class));
            }
        });





    }
}