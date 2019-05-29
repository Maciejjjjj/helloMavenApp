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
            e.getMessage();
        }

        // Serialization

        Map<Integer, String> lines = new HashMap<>();

        studentListMap.forEach((key, value) -> lines.put(key, value.getName() + " " + value.getSurname() + " age: " + value.getAge()));

        try(FileOutputStream fos = new FileOutputStream("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\listOfStudents.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            out.writeObject(lines);

            System.out.println("Serialized data is saved in listOfStudents.ser");
        } catch (IOException e) {
            e.getMessage();
        }


        Map<Integer, Student> deserializedStudentListMap;

        try (FileInputStream fis = new FileInputStream("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\listOfStudents.ser");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            deserializedStudentListMap = (HashMap<Integer, Student>) ois.readObject();

        } catch (IOException ioe) {
            ioe.getMessage();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.getMessage();
            return;
        }

        System.out.println("Deserialized HashMap..");

        for (Map.Entry<Integer, Student> entry : deserializedStudentListMap.entrySet() ){
            System.out.print(entry.getKey() + ". ");
            System.out.println(entry.getValue());
        }
    }
}
