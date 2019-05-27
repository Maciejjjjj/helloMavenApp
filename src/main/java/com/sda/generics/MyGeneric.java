package com.sda.generics;

public class MyGeneric<T> {

    private T field;

    public MyGeneric(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }


}
