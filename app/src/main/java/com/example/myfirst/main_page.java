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
        /////////////////////////////////////////////////////
        ContactDBHelper helper = new ContactDBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.onStart(db);
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;


        ////////////////////////////////////////////////////////////////
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new MyListener());
        next_b = (Button) findViewById(R.id.main_n);
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
                System.out.println("n is "+n);
            }
        });
        previous_b = (Button) findViewById(R.id.main_p);
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
                System.out.println("n is "+n);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        //밑에 있는 거는 모든 페이지에서 필요한 버튼들 2,3,0
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
                ////////////////////////////////////////////////////////////
               if(cursor == null || cursor.getCount() ==0){
                    Intent intent3 = new Intent(getApplicationContext(),mypage_be.class);//my page로 돌가는 버튼
                startActivity(intent3);
                   System.out.println(cursor.getCount() +"전전전전전   ~~~~~~~~~~~~~~~~");}
                else {
                  //  Intent intent2 = new Intent(getApplicationContext(),mypage_af.class);
                    //startActivity(intent2);
                   System.out.println("후후후후후후후훟~~~~~~~~~~~~~~~~~~");
                }
                ///////////////////////////////////////////
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
