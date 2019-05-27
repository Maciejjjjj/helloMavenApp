package com.sda.fileoperation.FilesHomeTask3;

import com.sda.homelisttask.Student;
import com.sda.homelisttask.factory.StudentRandomFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FilesOperations {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Agnieszka", "Joanna", "Patrycja", "Zuzanna", "Anna", "Tomasz", "Andrzej", "Adam", "Marek", "Patryk");
        List<String> surnames = Arrays.asList("Nowak", "Wójcik", "Kowalczyk", "Woźniak", "Mazur", "Krawczyk", "Kaczmarek", "Zając", "Król", "Dudek");

        StudentRandomFactory factory = new StudentRandomFactory();

        List<Student> students = factory.randomizeStudents(names, surnames, 10, 1);

        Map<Integer, Student> studentListMap = new HashMap<Integer, Student>();
        for (Student student : students) {
            studentListMap.put(students.indexOf(student) + 1, student);
        }

        // Converting list to string
//        List<String> lines = new ArrayList<String>();
//        students.forEach( student -> lines.add(student.getName() + " " + student.getSurname() + " " + student.getAge()));

        //  Writing map to file
        Path filePath = Paths.get("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\listOfStudents.txt");
        try (Writer writer = Files.newBufferedWriter(filePath)) {
            studentListMap.forEach((key, student) -> {
                try {
                    writer.write(key + " " + student.getName() + " " + student.getSurname() + " age: " + student.getAge() + System.lineSeparator());
                } catch (IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Writing map to file method 2, map to String
//            try {
//                List<String> lines = new ArrayList<String>();
//                studentListMap.forEach((key, value) -> lines.add(key + " " + value.getName() + " " + value.getSurname() + " age: " + value.getAge()));
//                Path filePath = Paths.get("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\listOfStudents.txt");
//                Files.write(filePath, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }

        // Serialization

        Map<Integer, String> lines = new HashMap<>();

        studentListMap.forEach((key, value) -> lines.put(key, value.getName() + " " + value.getSurname() + " age: " + value.getAge()));

        try {
            FileOutputStream fos =
                    new FileOutputStream("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\listOfStudents.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(lines);
            out.close();
            fos.close();
            System.out.println("Serialized data is saved in listOfStudents.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<Integer, Student> deserializedStudentListMap = null;

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\listOfStudents.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            deserializedStudentListMap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized HashMap..");

        Set set = deserializedStudentListMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            System.out.print(mapEntry.getKey() + ". ");
            System.out.println(mapEntry.getValue());
        }
    }
}
