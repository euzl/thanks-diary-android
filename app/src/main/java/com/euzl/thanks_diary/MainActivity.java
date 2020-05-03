package com.euzl.thanks_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int nowData = 0;
    Cursor cursor;
    TextView date;
    TextView t1;
    String diaryDate;
    String diaryContent;
    int numberOfData;

    ArrayList<MomentData> momentDataList;

     //TODO: 2020-04-09 momentDataList 개수받아와서 총 n번의 순간으로. 달 구분하는거는 좀 더 ㅠㅠ
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InitializeMomentData();

        ListView listView = (ListView)findViewById(R.id.thanksListView);
        final MomentAdapter mAdapter = new MomentAdapter(this, momentDataList);

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "이거클릭 : " + mAdapter.getItem(position).getThing(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void writeBtn(View v) {
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }

    // TODO: 2020-04-09 다이얼로그에 입력하면 momentDataList에 추가되도록 구현
    public void InitializeMomentData() {
        momentDataList = new ArrayList<>();

        date = findViewById(R.id.date);
        t1 = findViewById(R.id.content);

        try {
            DBManager dbmgr = new DBManager(this);
            SQLiteDatabase sdb = dbmgr.getReadableDatabase();
            cursor = sdb.query("momentTB", null, null, null, null, null, null);
            numberOfData = cursor.getCount();
            cursor.moveToFirst();

            if(numberOfData == 0) nowData = 0;
            else nowData = 1;

            if (cursor.getCount() > 0) {
                diaryDate = cursor.getString(0);
                diaryContent = cursor.getString(1);
            }
            cursor.close();
            dbmgr.close();
        } catch (SQLiteException e){

        }
        date.setText(diaryDate);
        t1.setText(diaryContent);
        momentDataList.add(new MomentData(3, diaryContent));

//        momentDataList.add(new MomentData(9, "최고로고맙"));
//        momentDataList.add(new MomentData(8, "최고로ㅇ고맙"));
//        momentDataList.add(new MomentData(7, "최고로ㅇㅇㅇ고맙"));
    }
}
