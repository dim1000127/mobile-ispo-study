package com.example.laba33;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    String name, content;
    Time time;
    Priority priority;

    public Note(String _name, String _content, Time _time, Priority _priority){
        name = _name;
        content = _content;
        time = _time;
        priority = _priority;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Time getTime() {
        return time;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
