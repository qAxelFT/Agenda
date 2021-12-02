package com.agenda;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class ThreeColumn_ListAdapter extends ArrayAdapter<Task>
{
    private LayoutInflater mInfalter;
    private ArrayList<Task> tasks;
    private int mViewResourceID;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceID, ArrayList<Task> tasks)
    {
        super(context, textViewResourceID, tasks);
        this.tasks = tasks;
        mInfalter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceID = textViewResourceID;
    }

    public View getView(int position, View convertView, ViewGroup parents)
    {
        convertView = mInfalter.inflate(mViewResourceID, null);

        Task task = tasks.get(position);

        if(task != null)
        {
            TextView title = (TextView) convertView.findViewById(R.id.textTitle);
            TextView due = (TextView) convertView.findViewById(R.id.textDue);
            TextView priority = (TextView) convertView.findViewById(R.id.textPriority);

            title.setText(task.getTitle());
            due.setText(task.getDue());
            priority.setText(task.getPriority());
        }

        return convertView;
    }


}
