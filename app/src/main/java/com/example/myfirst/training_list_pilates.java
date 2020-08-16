package com.example.myfirst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class training_list_pilates extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_list_pilates);
        ListView listview = (ListView)findViewById(R.id.listview);
        // 3. 실제로 문자열 데이터를 저장하는데 사용할 ArrayList 객체를 생성합니다.
        final ArrayList<String> list = new ArrayList<>();

        // 4. ArrayList 객체에 데이터를 집어넣습니다.
        list.add(0,"소도구 필라테스");
        list.add(0,"매트 필라테스");
        list.add(0,"필라테스");

// 5. ArrayList 객체와 ListView 객체를 연결하기 위해 ArrayAdapter객체를 사용합니다.
        // 우선 ArrayList 객체를 ArrayAdapter 객체에 연결합니다.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, //context(액티비티 인스턴스)
                android.R.layout.simple_list_item_1, // 한 줄에 하나의 텍스트 아이템만 보여주는 레이아웃 파일
                // 한 줄에 보여지는 아이템 갯수나 구성을 변경하려면 여기에 새로만든 레이아웃을 지정하면 됩니다.
                list  // 데이터가 저장되어 있는 ArrayList 객체
        );



        // 6. ListView 객체에 adapter 객체를 연결합니다.
        listview.setAdapter(adapter);



        // 7. ListView 객체의 특정 아이템 클릭시 처리를 추가합니다.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                // 8. 클릭한 아이템의 문자열을 가져와서
                String selected_item = (String)adapterView.getItemAtPosition(position);

                if(selected_item.equals("소도구 필라테스")){
                    Intent intent0 = new Intent(getApplicationContext(),main_page.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent0);
                }
                else if(selected_item.equals("매트 필라테스")){
                    Intent intent1 = new Intent(getApplicationContext(),mypage_af.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent1);
                }
                else if(selected_item.equals("필라테스")){
                    Intent intent2 = new Intent(getApplicationContext(),mypage_be.class);//지인쓰 카메라쪽으로 갈 예정
                    startActivity(intent2);
                }

                // 10. 어댑터 객체에 변경 내용을 반영시켜줘야 에러가 발생하지 않습니다.
                adapter.notifyDataSetChanged();
            }
        });

    }
}


