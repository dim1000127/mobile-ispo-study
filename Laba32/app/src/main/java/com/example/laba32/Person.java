package com.example.laba32;

public class Person {

    String name;
    int age;
    Sex sex;
    Status status;

    public Person (String _name, int _age, Sex _sex, Status _status){
        name = _name;
        age = _age;
        sex = _sex;
        status = _status;
    }

    public String toString(){
        String str = name + " " + age + " " + sex  + " " + status;
        return str;
    }
}
