package com.example.myfirst;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirst.R;

public class mypage_af extends AppCompatActivity {
    public static main_page mp = new main_page();

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_after);

        //load();
        mp.check=1;
        Button b1;
        Button home_b;
        Button info_b;
        TextView textViewName = (TextView) findViewById(R.id.textName);
        TextView textViewOld = (TextView) findViewById(R.id.textOld);
        TextView textViewTall = (TextView) findViewById(R.id.textTall);
        TextView textViewWeight = (TextView) findViewById(R.id.textWeight);
        final ContactDBHelper dbHelper = new ContactDBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;
        cursor.moveToFirst();
        textViewName.setText(cursor.getString(0));
        textViewOld.setText(Integer.toString(cursor.getInt(1)));
        textViewTall.setText(Integer.toString(cursor.getInt(2)));
        textViewWeight.setText(Integer.toString(cursor.getInt(3)));

       b1 = (Button) findViewById(R.id.buttonreturn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.onDowngrade(db);
                Intent intent1 = new Intent(getApplicationContext(), mypage_be.class);
                startActivity(intent1);
            }
        });
        home_b = (Button) findViewById(R.id.b_home);
        home_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),main_page.class);//home 버튼으로 가는 버튼
                startActivity(intent2);
            }
        });
        //////////////////////////////////////////
        //수정해야하는 부분
        info_b = (Button) findViewById(R.id.b_info);
        info_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor == null || cursor.getCount() ==0) {
                    Intent intent3 = new Intent(getApplicationContext(),mypage_be.class);//my page로 돌가는 버튼
                    startActivity(intent3);
                    System.out.println("mypage_before로 갈거얌야야야야양");
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(),mypage_af.class);
                    startActivity(intent2);
                    System.out.println("mypage_after로 갈거얌얌야먀야야양");
                }
            }
        });

    }
    private void load () {

    }
}
