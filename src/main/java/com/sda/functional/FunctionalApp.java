package com.sda.functional;

import com.sda.homelisttask.Student;
import com.sda.homelisttask.factory.StudentRandomFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FunctionalApp {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Agnieszka", "Joanna", "Patrycja", "Zuzanna", "Anna", "Tomasz", "Andrzej", "Adam", "Marek", "Patryk");
        List<String> surnames = Arrays.asList("Nowak", "Wójcik", "Kowalczyk", "Woźniak", "Mazur", "Krawczyk", "Kaczmarek", "Zając", "Król", "Dudek");
        StudentRandomFactory factory = new StudentRandomFactory();
        List<Student> students = factory.randomizeStudents(names, surnames, 10, 9);


    }

//    public List<String> mapStudentToNameList(List<Student> students){
//
//    }

}
