package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student[] students = {
                new Student("ada", "QWD", Gender.Woman, 1),
                new Student("gab", "AAB", Gender.Woman, 2),
                new Student("abb", "ABB", Gender.Man, 3),
                new Student("bbb", "JRD", Gender.Woman, 4),
                new Student("bbc", "CAB", Gender.Woman, 5),
                /*new Student("jkc", "FAB", Gender.Woman, 6),
                new Student("ccc", "HAB", Gender.Woman, 7),
                new Student("ccd", "EAB", Gender.Man, 8),
                new Student("rtd", "JAB", Gender.Man, 9),
                new Student("mhg", "AUT", Gender.Woman, 10),
                new Student("dde", "OPC", Gender.Woman, 11),*/
        };

        Group g1 = new Group("First");

        for (int i=0;i< students.length;i++){
            try {
                g1.addStudent(students[i]);
            } catch (GroupOverflowException e) {
                e.printStackTrace();
            }
        }

        System.out.println(g1.toString());

        g1.deleteStudentById(8);

        try {
            System.out.println(g1.searchStudentByLastname("CAB"));
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(g1.searchStudentByLastname("CjB"));
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        EnterNewStudent.enterStudentAndAddGroup(new Student(),g1);

        g1.sortStudents();
        System.out.println(g1.toString());
    }
}
