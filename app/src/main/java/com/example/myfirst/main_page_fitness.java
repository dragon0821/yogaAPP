package com.example.myfirst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class main_page_fitness extends AppCompatActivity {
    Button home_b;
    Button info_b;
    Button return_b;
    Button next_b;
    Button previous_b;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_fitness);
        next_b = (Button) findViewById(R.id.main_n);
        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(),main_page_fitness.class);
                startActivity(intent4);
            }
        });
        previous_b = (Button) findViewById(R.id.main_p);
        previous_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(),main_page_pilates.class);
                startActivity(intent4);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        //밑에 있는 거는 모든 페이지에서 필요한 버튼들 2,3,0
        home_b = (Button) findViewById(R.id.b_home);
        home_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),main_page_yoga.class);//home 버튼으로 가는 버튼
                startActivity(intent2);
            }
        });
        info_b = (Button) findViewById(R.id.b_info);
        info_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),mypage_af.class);//my page로 돌가는 버튼
                startActivity(intent3);
            }
        });
        return_b = (Button) findViewById(R.id.b_return);
        return_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplicationContext(),main_page_yoga.class);//home 버튼을 돌아가는 버튼
                startActivity(intent0);
            }
        }) ;
    }
}
