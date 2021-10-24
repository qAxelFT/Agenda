package com.agenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddEvent extends AppCompatActivity
{
    InternalStorageManagement taskDB;
    Button button;
    EditText _title, _due, _priority;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_activity);

        taskDB = new InternalStorageManagement(this);

        button = (Button) findViewById(R.id.button_save);
        _title = (EditText) findViewById(R.id.Title);
        _due = (EditText) findViewById(R.id.Due);
        _priority = (EditText) findViewById(R.id.Priority);

        save();
    }

    public void save()
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String title = _title.getText().toString();
                String due = _due.getText().toString();
                int priority = Integer.parseInt(_priority.getText().toString());

                boolean insertData = taskDB.addData(title, due, priority);

                if(insertData)
                {
                    Toast.makeText(AddEvent.this, "Data was succesfully saved", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
