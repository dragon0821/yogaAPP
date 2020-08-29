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
    Button b1;
    Button home_b;
    Button info_b;
    TextView textViewName;
    TextView textViewOld ;
    TextView textViewTall;
    TextView textViewWeight ;
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_after);

        mp.check=1; //테이블이 있고 테이블에 값이 들어있다는 것을 알림

        final ContactDBHelper dbHelper = new ContactDBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;

        declare();
        setText(cursor);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase() ;
                dbHelper.onDowngrade(db);//회원정보를 다 지우고 다시 기입할 수 있게 함
                Intent intent1 = new Intent(getApplicationContext(), mypage_be.class);
                startActivity(intent1);
            }
        });

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
                if(cursor == null || cursor.getCount() ==0) {
                    Intent intent3 = new Intent(getApplicationContext(),mypage_be.class);//my page로 돌가는 버튼
                    startActivity(intent3);
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(),mypage_af.class);
                    startActivity(intent2);
                }
            }
        });

    }
    void declare(){
        textViewName = (TextView) findViewById(R.id.textName);
        textViewOld = (TextView) findViewById(R.id.textOld);
        textViewTall = (TextView) findViewById(R.id.textTall);
        textViewWeight = (TextView) findViewById(R.id.textWeight);
        b1 = (Button) findViewById(R.id.buttonreturn);//return으로 다시 회원 정보를 기입
        home_b = (Button) findViewById(R.id.b_home);
        info_b = (Button) findViewById(R.id.b_info);
    }
    void setText (Cursor cursor) {
        cursor.moveToFirst();
        textViewName.setText(cursor.getString(0));
        textViewOld.setText(Integer.toString(cursor.getInt(1)));
        textViewTall.setText(Integer.toString(cursor.getInt(2)));
        textViewWeight.setText(Integer.toString(cursor.getInt(3)));
    }
}
