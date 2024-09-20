package Lesson_9._fileStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputAndOutputStream {
    public static void main(String[] args) {

    String text = "Try to write text!"; //пытаемся передать эту строку в файл
    //но для начала эту строку нужно перевести в массив байтов
    byte [] textToWrite = text.getBytes();

    try(FileOutputStream outputStream =
            new FileOutputStream("C:\\Users\\Defarion\\Desktop\\QA7\\file\\text.txt"))
    {

        outputStream.write(textToWrite);

    } catch (IOException e){
        System.out.println(e.getMessage());
    }

        System.out.println("=====");
    //чтобы читать инфо с файла нам нужен какой-то буфер, в который мы будем помещать эту инфо
        byte[] bufferByte = new byte[10];
        //инфо которрую мы будем считывать, мы будем делать это посимвольно и будем размещать в какую-то строку чтобы собрать весь текст
        StringBuilder textToRead = new StringBuilder();
        //дальше делаем трай и кетч внутри с ресурсами
        try (FileInputStream fileInput =
                new FileInputStream("C:\\Users\\Defarion\\Desktop\\QA7\\file\\text.txt")){

            int count;
            while ((count=fileInput.read(bufferByte)) > 0){
                for (int i = 0; i < count; i++){
                    textToRead.append((char) bufferByte[i]);
                }
            }
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println(textToRead);


    }
}
