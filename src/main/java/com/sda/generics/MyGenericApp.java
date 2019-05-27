package com.sda.generics;

public class MyGenericApp {

    public static void main(String[] args) {
        MyGenericString myString = new MyGenericString("Test");
        MyGenericDouble myDouble = new MyGenericDouble(3.14);

        MyGeneric<String> myGenericString = new MyGeneric<>("test");
        MyGeneric<Double> myGenericDouble = new MyGeneric<>(3.14);
    }
}
