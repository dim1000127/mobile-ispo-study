package com.example.laba30;

import java.io.Serializable;

public enum Priority implements Serializable {
    HIGH,
    MEDIUM,
    LOW;
    public static Priority valueOf(int ordinal){  //возвращение объекта по его индексу
        for (Priority item: values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}

