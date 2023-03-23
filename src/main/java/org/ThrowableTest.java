package org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowableTest {
    public static void main(String[] args) {
        System.out.println(testreturn());
    }

    public static int testreturn(){
        try {
            System.out.println(111);
            return 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            return 2;
        }
    }
}
