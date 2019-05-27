package com.sda.homelisttask.factory;

import com.sda.homelisttask.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StudentRandomFactory {

    public List<Student> randomizeStudents(List<String> names, List<String> surnames, int numberOfStudents, int randomizeFactor) {
        List<Student> resultList = new LinkedList<Student>();

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis()*randomizeFactor);

        int nameIndex, surnameIndex;

        for (int i = 0; i < numberOfStudents; i++) {
            nameIndex = rand.nextInt(names.size());
            surnameIndex = rand.nextInt(surnames.size());
            resultList.add(new Student(names.get(nameIndex), surnames.get(surnameIndex), rand.nextInt(23) + 18));
        }
        return resultList;
    }

}
