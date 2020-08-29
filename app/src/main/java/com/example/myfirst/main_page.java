package com.example.myfirst;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class main_page extends AppCompatActivity{

    public static int n = 0;
    public int flag1 = 0;
    public int check = 0;
    Button home_b;
    Button info_b;
    Button return_b;
    Button next_b;
    Button previous_b;
    ImageView imageView = null;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        //밑에 함수 전까지의 선언들은 onCreate가 아니면 오류가 나옴
        ContactDBHelper helper = new ContactDBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        if(check==0)//어플을 처음 깔았을때만 table이 만들어진다.
        {helper.onStart(db);}
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;

        declare();
        buttons(cursor);

    }
    void declare () {
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new MyListener()); // imageview 클릭시에 event처리를 하기 위함
        next_b = (Button) findViewById(R.id.main_n);
        previous_b = (Button) findViewById(R.id.main_p);
        home_b = (Button) findViewById(R.id.b_home);
        info_b = (Button) findViewById(R.id.b_info);
    }
    void buttons(final Cursor cursor){
        //이미지만 바꾸기 위함
        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n==0) {
                    imageView.setImageResource(R.drawable.pilates);
                    n = 1;
                    flag1 = 1;
                }
                else if(n==1) {
                    imageView.setImageResource(R.drawable.fitness);
                    n=2;
                }
                else if(n==2) {
                    imageView.setImageResource(R.drawable.real_yoga);
                    n = 0;
                }
            }
        });

        previous_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n==0){
                    imageView.setImageResource(R.drawable.fitness);
                    n = 2;
                    flag1 = 1;
                }
                else if(n==1) {
                    imageView.setImageResource(R.drawable.real_yoga);
                    n = 0;
                }
                else if(n==2) {
                    imageView.setImageResource(R.drawable.pilates);
                    n = 1;
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        //밑에 있는 거는 모든 페이지에서 필요한 버튼들 2,3,0

        home_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),main_page.class);//home 버튼으로 가는 버튼
                startActivity(intent2);
            }
        });

        info_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( cursor == null || cursor.getCount() ==0) //DB에 기록이 없으면 기록 저장을 위한 page DB에 기록이 있으면 기록 저장된 페이지로
                {
                    Intent intent3 = new Intent(getApplicationContext(), mypage_be.class);
                    startActivity(intent3);
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(),mypage_af.class);
                    startActivity(intent2);
                }
            }
        });
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(flag1==0){
                Intent intent0 = new Intent(getApplicationContext(), training_list_yoga.class);//지인쓰 카메라쪽으로 갈 예정
                startActivity(intent0);
            }
            else {
                if (main_page.n == 0) {
                    Intent intent1 = new Intent(getApplicationContext(), training_list_yoga.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent1);
                } else if (main_page.n == 1) {
                    Intent intent2 = new Intent(getApplicationContext(), training_list_pilates.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent2);
                } else if (main_page.n == 2) {
                    Intent intent3 = new Intent(getApplicationContext(), training_list_fitness.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent3);
                }
            }
        } // end onClick


    } // end MyListener()

}
