package com.sda.fileoperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilesHomeTask1And2 {
    public static void main(String[] args) {
        File fileToRead = new File("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\numbers.txt");

        List<Integer> numbers = new LinkedList<>();

        if (fileToRead.exists()) {
            try (Scanner scanner = new Scanner(fileToRead)) {
                int i = 0;
                while (scanner.hasNext()) {
                    i++;

                    if (!scanner.hasNextInt()) {
                        scanner.next();
                        System.out.println("Line #" + i + " is not a number");

                    } else {
                        numbers.add(scanner.nextInt());
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("File not exists");
        }

        for (Integer line : numbers) {
            System.out.println(line);
        }
        System.out.println("******");

        numbers = numbers.stream().map(number -> {
            if (number < 20) {
                number = (int) Math.pow(number, 3);
            }
            return number;
        }).collect(Collectors.toList());

        for (Integer line : numbers) {
            System.out.println(line);
        }

    }

}
