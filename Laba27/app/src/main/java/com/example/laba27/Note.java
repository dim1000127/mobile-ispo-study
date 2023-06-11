package com.example.laba27;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    String name, content;
    Time time;

    public Note(String _name, String _content, Time _time){
        name = _name;
        content = _content;
        time = _time;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
