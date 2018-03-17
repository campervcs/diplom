package com.igumnov.common;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FileTest {

    @Before
    public void before() {
        java.io.File d = new java.io.File("tmp");
        if (!d.exists()) {
            d.mkdir();
        } else {
            Folder.deleteWithContent("tmp");
            d.mkdir();
        }
    }

    @Test
    public void testReadAllToStringByFileName() throws IOException {
        assertEquals(File.readAllToString("src/test/resources/File/readAllToStringByFileName.txt"), "123");
    }

    @Test
    public void testWriteStringByFileName() throws IOException {
        File.writeString("123\n123", "tmp/testWriteStringByFileName.txt");
        assertEquals(File.readAllToString("tmp/testWriteStringByFileName.txt"), "123\n123");
    }


    @Test
    public void testDeleteDirectoryWithContentByDirName() throws IOException {
        new java.io.File("tmp/deleteDir").mkdir();
        File.writeString("123", "tmp/deleteDir/1.txt");
        new java.io.File("tmp/deleteDir/sub").mkdir();
        File.writeString("123", "tmp/deleteDir/sub/2.txt");
        Folder.deleteWithContent("tmp/deleteDir");
        assertTrue(!new java.io.File("tmp/deleteDir").exists());
    }

    @Test
    public void testCopyDirectoryWithContentByDirName() throws IOException {

        new java.io.File("tmp/copy.src").mkdir();
        new java.io.File("tmp/copy.src/f1").mkdir();
        File.writeString("123", "tmp/copy.src/1.txt");
        File.writeString("123", "tmp/copy.src/f1/2.txt");
        Folder.copyWithContent("tmp/copy.src", "tmp/copy.out");
        assertTrue(new java.io.File("tmp/copy.out/1.txt").exists());
        assertTrue(new java.io.File("tmp/copy.out/f1/2.txt").exists());

    }

}