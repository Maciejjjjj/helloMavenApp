package com.sda.fileoperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadFileApplication {

    public static void main(String[] args) {
        File fileToRead = new File("C:\\Users\\Twoja stara\\Desktop\\projekty\\Java\\1Kurs\\Projekty\\HelloMavenApplication\\test.txt");

        List<String> lines = new LinkedList<>();

        if (fileToRead.exists()) {
            try (Scanner scanner = new Scanner(fileToRead)) {
                while (scanner.hasNext()) {
                    lines.add(scanner.nextLine());
                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String line : lines) {
            System.out.println(line);
        }


    }
}
