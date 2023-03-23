package Serial;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student student1 = new Student("lihao", "wjwlh", "21");
        oos.writeObject(student1);
        oos.flush();
        oos.close();
        //反序列化
        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student2 = (Student) ois.readObject();
        System.out.println(student2.getUserName()+ " " +
                student2.getPassword() + " " + student2.getYear());
    }
}

class Student implements Serializable{

    private static final long serialVersionUID = -6060343040263809614L;

    private  String userName;
    private transient String password;
    private String year;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Student(String userName, String password, String year) {
        this.userName = userName;
        this.password = password;
        this.year = year;
    }
}
