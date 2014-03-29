package com.superslug.myapplication3.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class TaskActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Bundle bun = getIntent().getExtras();
        String name = bun.getString("name");
        String description = bun.getString("description");
        String date_due = bun.getString("date_due");
        int priority = bun.getInt("priority");
        ArrayList<String> labels = (ArrayList) bun.getSerializable("labels");


    }


}
