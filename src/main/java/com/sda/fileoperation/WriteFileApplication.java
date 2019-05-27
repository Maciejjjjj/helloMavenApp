package com.sda.fileoperation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class WriteFileApplication {
    public static void main(String[] args) {

        try {
            List<String> surnames = Arrays.asList("Nowak", "Wójcik", "Kowalczyk", "Woźniak", "Mazur");
            Path filePath = Paths.get("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\surnamestest.txt");
            Files.write(filePath, surnames, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
