package com.example.laba29;

public enum Sex {
    Male,
    Female;

    public static Sex valueOf(int ordinal){  //возвращение объекта по его индексу
        for (Sex item: values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

}
