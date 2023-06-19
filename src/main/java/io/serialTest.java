package io;

import java.io.*;

public class serialTest {
    public static void main(String[] args) {
        //序列化
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
//            Address addr = new Address("nanchang");
//            serialObeject yu = new serialObeject("yu", addr);
//
//            oos.writeObject(yu);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //反序列化
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
            serialObeject obj = (serialObeject) ois.readObject();

            System.out.println(obj.name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
