package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mypage_be extends AppCompatActivity {

    Button home_b;
    Button info_b;
    Button return_b;
    Button buttonSave;
    Button buttonClear;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_before);

        final ContactDBHelper dbHelper = new ContactDBHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        dbHelper.onStart(db);
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;

        declare();



        //edittext에 값을 입력하여 저장하기를 누르면 db에 삽입을 하고 db에 있는 회원정보를 저장한 page를 보여준다
        buttonSave.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                dbinsert(dbHelper);
               Intent intent10 = new Intent(getApplicationContext(),mypage_af.class);
               startActivity(intent10);
            }
        });

        buttonClear.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
              dbHelper.onDowngrade(db);
            }
        });

        ///////////////////////////////////////////////////////////////////////////////
        //밑에 있는 거는 모든 페이지에서 필요한 버튼들

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

        return_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplicationContext(),main_page.class);//home 버튼을 돌아가는 버튼
                startActivity(intent0);
            }
        }) ;
    }
    void declare(){
     buttonSave = (Button) findViewById(R.id.buttonSave);
     buttonClear = (Button) findViewById(R.id.buttonClear) ;
     home_b = (Button) findViewById(R.id.b_home);
     info_b = (Button) findViewById(R.id.b_info);
     return_b = (Button) findViewById(R.id.b_return);
    }
    void dbinsert(ContactDBHelper dbHelper){

        SQLiteDatabase db = dbHelper.getWritableDatabase() ;
        //name edit text에 적은 내용을 가져온다.
        EditText editTextName = (EditText) findViewById (R.id.eTName);
        String name = editTextName.getText().toString();

        //old edit text에 적은 내용을 가져온다.
        EditText editTextold = (EditText) findViewById (R.id.eTOld);
        int old = Integer.parseInt(editTextold.getText().toString());

        //tall edit text에 적은 내용을 가져온다.
        EditText editTexttall = (EditText) findViewById (R.id.eTTall);
        int tall = Integer.parseInt(editTexttall.getText().toString());

        //weight edit text에 적은 내용을 가져온다.
        EditText editTextweight = (EditText) findViewById(R.id.eTWeight);
        int weight = Integer.parseInt(editTextweight.getText().toString());


        String sqlInsert = ContactDBCtrct.SQL_INSERT +
                " (" +
                "'" + name + "', " +
                Integer.toString(old) + ", " +
                Integer.toString(tall) + ", " +
                Integer.toString(weight)  +
                ")" ;
        db.execSQL(sqlInsert);
    }
  }