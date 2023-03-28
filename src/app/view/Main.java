package app.view;

import app.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String PATH_FILE = "src/database/test.csv";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Trịnh Đức Toàn", "Hà Nội"));
        students.add(new Student(2, "Lê Việt Dũng", "Phú Thọ"));
        students.add(new Student(3, "Phùng Trung Dũng", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Đồng Chính", "Hải Dương"));
        writeToFile(PATH_FILE, students);
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }

    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
