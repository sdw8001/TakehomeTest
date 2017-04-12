package com.example.takehometest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.takehometest.apilist.ApiActivity;
import com.example.takehometest.maskinglist.MaskingActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMaskingActivity;
    private Button btnApiActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMaskingActivity = (Button) findViewById(R.id.btnMaskingList);
        btnApiActivity = (Button) findViewById(R.id.btnApiList);

        btnMaskingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MaskingActivity.class);
                startActivity(intent);
            }
        });

        btnApiActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApiActivity.class);
                startActivity(intent);
            }
        });
    }
}
