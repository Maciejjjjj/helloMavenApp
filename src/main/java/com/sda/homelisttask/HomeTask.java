package com.sda.homelisttask;

import com.sda.homelisttask.factory.StudentRandomFactory;

import java.util.*;

public class HomeTask {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Agnieszka", "Joanna", "Patrycja", "Zuzanna", "Anna", "Tomasz", "Andrzej", "Adam", "Marek", "Patryk");
        List<String> surnames = Arrays.asList("Nowak", "Wójcik", "Kowalczyk", "Woźniak", "Mazur", "Krawczyk", "Kaczmarek", "Zając", "Król", "Dudek");

        StudentRandomFactory factory = new StudentRandomFactory();

        List<Student> students = factory.randomizeStudents(names, surnames, 10, 1);

        //---------------------------------------------------- below task 2

        List<Student> firstSubList = students.subList(0, 5);
        List<Student> secondSubList = students.subList(5, 10);

//        Summing lists:
//        List<Student> sumList = new ArrayList<Student>();
//        sumList.addAll(firstSubList);
//        sumList.addAll(secondSubList);

        int marekIndex = -1;

        for (int i = 0; i < firstSubList.size(); i++) {
            if ("Marek".equals(firstSubList.get(i).getName())) {
                marekIndex = i;
            }
        }

        if (marekIndex == -1) {
            System.out.println("Student Marek is not on the list.");
        }
        if (marekIndex > -1) {
            System.out.println("Student Marek is #" + (marekIndex + 1) + " on the list.");
        }

        int sumAge = 0;

        for (Student student : secondSubList) {
            if (student.getName().startsWith("A")) {
                sumAge += student.getAge();
            }
        }

        System.out.println("Sum of age A-naming students is " + sumAge + ".");

        //------------------------------------------ below task 3

        Map<Integer, List<Student>> schoolMap = new TreeMap<Integer, List<Student>>();

        schoolMap.put(1,factory.randomizeStudents(names, surnames, 12, 234));
        schoolMap.put(2,factory.randomizeStudents(names, surnames, 8, 56));
        schoolMap.put(3,factory.randomizeStudents(names, surnames, 15, 7));

        for (Map.Entry<Integer, List<Student>> entry: schoolMap.entrySet()) {
            System.out.println("Class " + entry.getKey());

            for (Student student: entry.getValue()){
                System.out.println("- " + student.getName() + " " + student.getSurname() + ", age: " + student.getAge());
            }
        }

    }


}
