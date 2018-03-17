package com.igumnov.common;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Folder {
    public static void deleteWithContent(String dirName) {
        java.io.File folder = new java.io.File(dirName);
        java.io.File[] files = folder.listFiles();
        if(files!=null) {
            for(java.io.File f: files) {
                if(f.isDirectory()) {
                    deleteWithContent(f.getPath());
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public static void copyWithContent(String sourceDirName, String targetDirName) throws IOException {


        abstract class MyFileVisitor implements FileVisitor<Path> {
            boolean isFirst = true;
            Path ptr;
        }

        MyFileVisitor copyVisitor = new MyFileVisitor() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (!isFirst) {
                    Path target = ptr.resolve(dir.getName(dir.getNameCount() - 1));
                    ptr = target;
                }
                Files.copy(dir, ptr, StandardCopyOption.COPY_ATTRIBUTES);
                isFirst = false;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path target = ptr.resolve(file.getFileName());
                Files.copy(file, target, StandardCopyOption.COPY_ATTRIBUTES);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                throw exc;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Path target = ptr.getParent();
                ptr = target;
                return FileVisitResult.CONTINUE;
            }
        };

        copyVisitor.ptr = Paths.get(targetDirName);
        Files.walkFileTree(Paths.get(sourceDirName), copyVisitor);

    }
}
