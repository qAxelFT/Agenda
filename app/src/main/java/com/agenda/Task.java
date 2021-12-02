package com.agenda;

public class Task
{
    private String _title;
    private String _due;
    private String _priority;

    public Task(String title, String due, String priority)
    {
        _title = title;
        _due = due;
        _priority = priority;
    }

    public String getTitle()
    {
        return _title;
    }

    public String getDue()
    {
        return _due;
    }

    public String getPriority()
    {
        return _priority;
    }
}
