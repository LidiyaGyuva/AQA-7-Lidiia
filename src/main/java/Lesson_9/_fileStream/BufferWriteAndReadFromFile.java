package Lesson_9._fileStream;

import java.io.*;

public class BufferWriteAndReadFromFile {
    public static void main(String[] args) {

        //WRITE

        try (OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream("C:\\Users\\Defarion\\Desktop\\QA7\\file\\text2.txt")
        )){
            outputStream.write("Text to add".getBytes());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //READ
        StringBuilder resultText = new StringBuilder();
        try(InputStream inputStream = new BufferedInputStream(
                new FileInputStream("C:\\Users\\Defarion\\Desktop\\QA7\\file\\text2.txt"))){
            int x;
            while ((x=inputStream.read()) != -1){
                resultText.append((char) x);
            }
        }catch (IOException a){
            System.out.println(a.getMessage());
        }
        System.out.println(resultText);

    }
}
