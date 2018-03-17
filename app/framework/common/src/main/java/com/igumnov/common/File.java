package com.igumnov.common;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class File {
    public static String readAllToString(String fileName) throws IOException {
        java.io.File file = new java.io.File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        return new String(data, "UTF-8");
    }

    public static void writeString(String str, String fileName) throws IOException {
        try ( Writer out = new BufferedWriter( new OutputStreamWriter(
                new FileOutputStream( fileName ), "UTF-8" ) ) ) {
            out.write( str );
        }
    }

    public static void appendLine(String line, String filename) throws IOException {
        try(PrintWriter output = new PrintWriter(new FileWriter(filename,true)))
        {
            output.printf("%s\r\n", line);
        }
    }

    public static Stream<String> readLines(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName));
    }
}
