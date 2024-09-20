package Lesson_9._fileStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteInputOutputStreamExample {
    //inputStream для чтения стрима
    public static void main(String[] args) {
        byte[] array = {12,44,-55};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array);
        int x;
        while ((x = byteStream.read())!= -1){
            System.out.print(x + " ");
        }

        //output stream для записи в стрим
        System.out.println("=======");
        System.out.println();
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        byteOutput.write(23);
        byteOutput.write(199);
        byteOutput.write(2);
        byte [] arrayFromOutput = byteOutput.toByteArray();
        System.out.println(Arrays.toString(arrayFromOutput));


    }

}
