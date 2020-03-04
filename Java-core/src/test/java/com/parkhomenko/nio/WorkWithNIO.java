package com.parkhomenko.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * https://www.baeldung.com/java-nio-2-file-api
 */
public class WorkWithNIO {

    private static String HOME = System.getProperty("user.home");

    @Test
    public void givenExistentPath_whenConfirmsFileExists_thenCorrect() {
        Path p = Paths.get(HOME);

        assertTrue(Files.exists(p));
    }

    @Test
    public void givenDirPath_whenConfirmsNotRegularFile_thenCorrect() {
        Path p = Paths.get(HOME);

        assertFalse(Files.isRegularFile(p));
    }

    @Test
    public void givenExistentDirPath_whenConfirmsReadable_thenCorrect() {
        Path p = Paths.get(HOME);

        assertTrue(Files.isReadable(p));
    }

    @Test
    public void givenExistentDirPath_whenConfirmsWritable_thenCorrect() {
        Path p = Paths.get(HOME);

        assertTrue(Files.isWritable(p));
    }

    @Test
    public void givenExistentDirPath_whenConfirmsExecutable_thenCorrect() {
        Path p = Paths.get(HOME);
        assertTrue(Files.isExecutable(p));
    }

    @Test
    public void givenSameFilePaths_whenConfirmsIsSame_thenCorrect() throws IOException {
        Path p1 = Paths.get(HOME);
        Path p2 = Paths.get(HOME);

        assertTrue(Files.isSameFile(p1, p2));
    }

    @Test
    public void givenFilePath_whenCreatesNewFile_thenCorrect() throws IOException {
        String fileName = "myfile_" + UUID.randomUUID().toString() + ".txt";
        Path p = Paths.get(HOME + "/" + fileName);

        assertFalse(Files.exists(p));

        Files.createFile(p);

        assertTrue(Files.exists(p));
    }

    @Test
    public void givenDirPath_whenCreatesNewDir_thenCorrect() throws IOException {
        String dirName = "myDir_" + UUID.randomUUID().toString();
        Path p = Paths.get(HOME + "/" + dirName);
        assertFalse(Files.exists(p));

        Files.createDirectory(p);

        assertTrue(Files.exists(p));
        assertFalse(Files.isRegularFile(p));
        assertTrue(Files.isDirectory(p));
    }

    @Test(expected = NoSuchFileException.class)
    public void givenDirPath_whenFailsToCreateRecursively_thenCorrect() throws IOException {
        String dirName = "myDir_" + UUID.randomUUID().toString() + "/subdir";
        Path p = Paths.get(HOME + "/" + dirName);
        assertFalse(Files.exists(p));

        Files.createDirectory(p);
    }

    @Test
    public void givenDirPath_whenCreatesRecursively_thenCorrect() throws IOException {
        Path dir = Paths.get(HOME + "/myDir_" + UUID.randomUUID().toString());
        Path subdir = dir.resolve("subdir");

        assertFalse(Files.exists(dir));
        assertFalse(Files.exists(subdir));

        Files.createDirectories(subdir);

        assertTrue(Files.exists(dir));
        assertTrue(Files.exists(subdir));
    }

    @Test
    public void givenFilePath_whenCreatesTempFile_thenCorrect() throws IOException {
        String prefix = "log_";
        String suffix = ".txt";
        Path p = Paths.get(HOME + "/");

        Files.createTempFile(p, prefix, suffix);

        assertTrue(Files.exists(p));
    }

    @Test
    public void givenPath_whenCreatesTempFileWithDefaults_thenCorrect() throws IOException {
        Path p = Paths.get(HOME + "/");

        Files.createTempFile(p, null, null);

        assertTrue(Files.exists(p));
    }

    @Test
    public void givenNoFilePath_whenCreatesTempFileInTempDir_thenCorrect() throws IOException {
        Path p = Files.createTempFile(null, null);

        assertTrue(Files.exists(p));
    }

    @Test
    public void givenPath_whenDeletes_thenCorrect() throws IOException {
        Path p = Paths.get(HOME + "/fileToDelete.txt");
        assertFalse(Files.exists(p));
        Files.createFile(p);
        assertTrue(Files.exists(p));

        Files.delete(p);

        assertFalse(Files.exists(p));
    }

    @Test(expected = NoSuchFileException.class)
    public void givenInexistentFile_whenDeleteFails_thenCorrect() throws IOException {
        Path p = Paths.get(HOME + "/inexistentFile.txt");
        assertFalse(Files.exists(p));

        Files.delete(p);
    }

    @Test
    public void givenInexistentFile_whenDeleteIfExistsWorks_thenCorrect() throws IOException {
        Path p = Paths.get(HOME + "/inexistentFile.txt");
        assertFalse(Files.exists(p));

        Files.deleteIfExists(p);
    }

    @Test(expected = DirectoryNotEmptyException.class)
    public void givenPath_whenFailsToDeleteNonEmptyDir_thenCorrect() throws IOException {
        Path dir = Paths.get(HOME + "/emptyDir" + UUID.randomUUID().toString());
        Files.createDirectory(dir);
        assertTrue(Files.exists(dir));

        Path file = dir.resolve("file.txt");
        Files.createFile(file);

        Files.delete(dir);

        assertTrue(Files.exists(dir));
    }

    @Test
    public void givenFilePath_whenCopiesToNewLocation_thenCorrect() throws IOException {
        Path dir1 = Paths.get(HOME + "/firstdir_" + UUID.randomUUID().toString());
        Path dir2 = Paths.get(HOME + "/otherdir_" + UUID.randomUUID().toString());

        Files.createDirectory(dir1);
        Files.createDirectory(dir2);

        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");

        Files.createFile(file1);

        assertTrue(Files.exists(file1));
        assertFalse(Files.exists(file2));

        Files.copy(file1, file2);

        assertTrue(Files.exists(file2));
    }

    @Test(expected = FileAlreadyExistsException.class)
    public void givenPath_whenCopyFailsDueToExistingFile_thenCorrect() throws IOException {
        Path dir1 = Paths.get(HOME + "/firstdir_" + UUID.randomUUID().toString());
        Path dir2 = Paths.get(HOME + "/otherdir_" + UUID.randomUUID().toString());

        Files.createDirectory(dir1);
        Files.createDirectory(dir2);

        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");

        Files.createFile(file1);
        Files.createFile(file2);

        assertTrue(Files.exists(file1));
        assertTrue(Files.exists(file2));

        Files.copy(file1, file2);

        Files.copy(file1, file2, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void givenFolder_whenGetListOfFilesInFolder_thenCorrect() throws URISyntaxException {
        URL resource = this.getClass().getClassLoader().getResource("test-files");

        Path path = Paths.get(resource.toURI());

        assertTrue(Files.exists(path));

        File[] files = path.toFile().listFiles();

        HashSet set = new HashSet<>(Arrays.asList("1.txt", "2.txt"));

        boolean res = Stream.of(files).allMatch(file -> set.contains(file.getName()));

        assertEquals(2,files.length);
        assertTrue(res);

    }

}
