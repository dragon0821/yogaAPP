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


    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_after);
        //load();
        Button b1;
        TextView textViewName = (TextView) findViewById(R.id.textName);
        TextView textViewOld = (TextView) findViewById(R.id.textOld);
        TextView textViewTall = (TextView) findViewById(R.id.textTall);
        TextView textViewWeight = (TextView) findViewById(R.id.textWeight);
        final ContactDBHelper dbHelper = new ContactDBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
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
                Intent intent1 = new Intent(getApplicationContext(), mypage_be.class);
                startActivity(intent1);
            }
        });

    }
    private void load () {

    }
}
