package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mypage_be extends AppCompatActivity {
    Button b1;
    Button home_b;
    Button info_b;
    Button return_b;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_before);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(getApplicationContext(),mypage_af.class);//저장하기 버튼
                startActivity(intent1);
            }
        });

        ///////////////////////////////////////////////////////////////////////////////
        //밑에 있는 거는 모든 페이지에서 필요한 버튼들
        home_b = (Button) findViewById(R.id.b_home);
        home_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),main_page.class);//home 버튼으로 가는 버튼
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
                Intent intent0 = new Intent(getApplicationContext(),main_page.class);//home 버튼을 돌아가는 버튼
                startActivity(intent0);
            }
        }) ;
    }
}