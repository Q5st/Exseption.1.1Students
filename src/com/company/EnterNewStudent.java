package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnterNewStudent {
    public static void enterStudentAndAddGroup(Student student, Group group){
        enterName(student);
        enterLastName(student);
        enterId(student);
        chooseGender(student);
        try {
            group.addStudent(student);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
    }

    public static void enterName(Student student){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        student.setName(name);
    }

    public static void enterLastName(Student student){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Lastname");
        String name = sc.nextLine();
        student.setLastName(name);
    }

    public static void enterId(Student student){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = sc.nextInt();
        student.setId(id);
    }

    public static void chooseGender(Student student) throws InputMismatchException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter true if Student is man, or falls if Student is woman");
        try {
            boolean gender = sc.nextBoolean();
            if (gender = true) {
                student.setGender(Gender.Man);
            } else {
                student.setGender(Gender.Woman);
            }
        }catch (InputMismatchException e){
            throw e;
        }
    }
}
