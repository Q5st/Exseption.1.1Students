package com.company;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GroupFileStorage {
    public static void saveGroupToCSV(Group gr) {
        try (FileWriter writer = new FileWriter(gr.getGroupName() + ".csv")) {
            for (int i = 0; i < gr.getStudents().length; i++) {
                if (gr.getStudents()[i] != null) {
                    String str = gr.getStudents()[i].getName() + ";" + gr.getStudents()[i].getLastName() + ";"
                            + gr.getStudents()[i].getId() + ";" + gr.getStudents()[i].getGender() + ";"
                            + gr.getStudents()[i].getGroupName() + "\n";
                    writer.write(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Group loadGroupFromCSV(File file) {
        Group group = new Group(file.getName());
        String[] str = new String[group.getStudents().length];

        try (Reader read = new FileReader(file)) {
            Scanner sc = new Scanner(read);
            for (int i = 0; sc.hasNextLine(); i++) {
                str[i] = sc.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < str.length; i++) {
            if (str[i] == null) {
                break;
            }
            String[] words = str[i].split("[;]");

            Student student = new Student(words[0], words[1], Gender.valueOf(words[3]), Integer.parseInt(words[2]));
            try {
                group.addStudent(student);
            } catch (GroupOverflowException e) {
                e.printStackTrace();
            }

        }

        return group;
    }

    public static File findFileByGroupName(String groupName, File workFolder){

        File[] files = workFolder.listFiles();
        for (File i: files){

            if(i.getName().equals(groupName)&&i.isFile()){
                return i;
            }
        }
        return null;
    }
}
