package com.example.laba29;

public enum Status {

    Pupil,
    Student,
    Worker,
    Teacher;

    public static Status valueOf(int ordinal){  //возвращение объекта по его индексу
        for (Status item: values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

}
