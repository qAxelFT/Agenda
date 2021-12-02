package com.agenda;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewContents extends AppCompatActivity
{

    InternalStorageManagement DB;
    ArrayList<Task> taskList;
    ListView listView;
    Task task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        DB = new InternalStorageManagement(this);
        taskList = new ArrayList<Task>();
        Cursor data = DB.showData();
        int numRows = data.getCount();

        if (numRows == 0)
            Toast.makeText(ListViewContents.this, "Data was succesfully saved", Toast.LENGTH_LONG).show();

        else
        {
            while(data.moveToNext())
            {
                task = new Task(data.getString(0), data.getString(1), data.getString(2));
                taskList.add(task);
            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.activity_main, taskList);
            listView = (ListView) findViewById(R.id.ListView);
            listView.setAdapter(adapter);
        }

    }
}
