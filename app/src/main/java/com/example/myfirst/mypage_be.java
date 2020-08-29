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
/////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////
    Button home_b;
    Button info_b;
    Button return_b;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_before);

        final ContactDBHelper dbHelper = new ContactDBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        dbHelper.onStart(db);
        final Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT, null) ;

        //init_tables();


        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

              //  save_values();
                SQLiteDatabase db = dbHelper.getWritableDatabase() ;
                //db.execSQL(ContactDBCtrct.SQL_DELETE); //하나의 레코드만 저장하기 때문(고칠것)
//////////////////////////////////////////////////////////////////////////////
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

               Intent intent10 = new Intent(getApplicationContext(),mypage_af.class);
               startActivity(intent10);
            }
        });
        Button buttonClear = (Button) findViewById(R.id.buttonClear) ;
        buttonClear.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
              //  delete_values();
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
        //////////////////////////////////////////
        //수정해야하는 부분
        info_b = (Button) findViewById(R.id.b_info);
        info_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(cursor == null || cursor.getCount() ==0) {
                    //Intent intent3 = new Intent(getApplicationContext(),mypage_be.class);//my page로 돌가는 버튼
                    //startActivity(intent3);}
                    System.out.println("mypage_before로 갈거얌야야야야양");
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(),mypage_af.class);
                    startActivity(intent2);
                    System.out.println("mypage_after로 갈거얌얌야먀야야양");
                }
            }
        });
        //////////////////////////////////////////////////////////////////////////
        return_b = (Button) findViewById(R.id.b_return);
        return_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplicationContext(),main_page.class);//home 버튼을 돌아가는 버튼
                startActivity(intent0);
            }
        }) ;
    }
  /* private void init_tables() {
        dbHelper = new ContactDBHelper(this) ;
    }
    private void load_values () {


        if(cursor.moveToFirst()) {
            //name(text) 값 가져오기
            String name = cursor.getString(0);
            EditText editTextName = (EditText) findViewById(R.id.eTName);
            editTextName.setText(name);

            //old(Integer) 값 가져오기
            int  old = cursor.getInt(1);
            EditText editTextold = (EditText) findViewById(R.id.eTOld);
            editTextold.setText(Integer.toString(old));

            //tall(Integer) 값 가져오기
            int tall = cursor.getInt(2);
            EditText editTexttall = (EditText) findViewById(R.id.eTTall);
            editTexttall.setText(Integer.toString(tall));

            //weight(Integer) 값 가져오기
            int weight = cursor.getInt(3);
            EditText editTextweight = (EditText) findViewById(R.id.eTWeight);
            editTextweight.setText(Integer.toString(weight));
        }
    }

    private void save_values() {
///////////////////////////////////////////////////////////////////////
        SQLiteDatabase db = dbHelper.getWritableDatabase() ;
        db.execSQL(ContactDBCtrct.SQL_DELETE); //하나의 레코드만 저장하기 때문(고칠것)
//////////////////////////////////////////////////////////////////////////////
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
    private void delete_values() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL(ContactDBCtrct.SQL_DELETE);

        EditText editTextname = (EditText) findViewById(R.id.eTName);
        editTextname.setText("");

        EditText editTextold = (EditText) findViewById(R.id.eTOld);
        editTextold.setText("");

        EditText editTexttall = (EditText) findViewById(R.id.eTTall);
        editTexttall.setText("");

        EditText editTextweight = (EditText) findViewById(R.id.eTWeight);
        editTextweight.setText("");
    }*/

}