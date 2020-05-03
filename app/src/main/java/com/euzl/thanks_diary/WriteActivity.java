package com.euzl.thanks_diary;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WriteActivity extends Activity {
    private DBManager dbmgr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    public void saveData(View v) {

        EditText dateEdt = findViewById(R.id.edt_date);
        String diary_date = dateEdt.getText().toString();

        EditText writeEdt = findViewById(R.id.edt_write);
        String diary_write = writeEdt.getText().toString();

        try {
            dbmgr = new DBManager(this);

            SQLiteDatabase sdb;

            sdb = dbmgr.getWritableDatabase();
            sdb.execSQL("insert into momentTB values(`" + diary_date +"`, `" + diary_write + "`);");

            dbmgr.close();
        } catch (SQLiteException e) {

        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
