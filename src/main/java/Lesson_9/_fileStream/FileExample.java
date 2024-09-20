package Lesson_9._fileStream;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File fileTest = new File("C:\\Users\\Defarion\\Desktop\\QA7\\file\\text.txt");
        System.out.println("Size file is   " +fileTest.length());
        System.out.println("NAME file is   " +fileTest.getName());
        System.out.println("Can i write   " +fileTest.canWrite());
        System.out.println("Can i read file   " +fileTest.canRead());
        System.out.println("Is it a directory?  " + fileTest.isDirectory());
        System.out.println("Is it a file?  " + fileTest.isFile());

        System.out.println("=============");

        File fileFolder = new File("C:\\Users\\Defarion\\Desktop\\QA7\\file");
        System.out.println("Is it a directory?  " + fileFolder.isDirectory());
        System.out.println("Is it a file?  " + fileFolder.isFile());
        File [] listOfFiles = fileFolder.listFiles();
        int counter = 1;
        for (File file: listOfFiles){
            System.out.println(counter + " ) " + file.getName());
            counter++;
        }


    }
}
