package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class reader {
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("input.txt")) {
            System.out.println("Number of remaining bytes:"
                    + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
