package com.sda.fileoperation;

import com.github.javafaker.ChuckNorris;
import com.github.javafaker.Faker;
import com.github.javafaker.Hipster;

import java.util.LinkedList;
import java.util.List;

public class WriteFakeNamesApp {

    public static void main(String[] args) {

        Faker faker = new Faker();
//        List<String> chucks = new LinkedList<>();
//        for (int i = 0; i < 10; i++){
//            ChuckNorris chuck = faker.chuckNorris();
//            chucks.add("Fact about Chuck Norris: " + chuck.fact());
//        }
//
//        for (String chuck: chucks){
//            System.out.println(chuck);
//        }

        List<String> hipsters = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            Hipster hipster = faker.hipster();
            hipsters.add("Hipster thing for today: " + hipster.word());
        }

        for (String hipster: hipsters){
            System.out.println(hipster);
        }
    }
}
