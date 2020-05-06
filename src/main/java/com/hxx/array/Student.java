package com.hxx.array;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {

        Array<Student> studentArray = new Array<Student>();
        studentArray.addLast(new Student("hxx", 10));
        studentArray.addLast(new Student("hxx1", 101));

        studentArray.addLast(new Student("hxx2", 102));
        System.out.println(studentArray);

    }

}
