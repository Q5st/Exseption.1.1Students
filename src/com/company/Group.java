package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public void addStudent(Student student) throws GroupOverflowException{
        for (int i=0; i<students.length; i++){
            if(this.students[i]==null){
                this.students[i]=student;
                student.setGroupName(this.groupName);
                return;
            }
            if (i==9){
                throw new GroupOverflowException();
            }
        }
    }

    public Student searchStudentByLastname(String lastname) throws StudentNotFoundException{
        for (int i = 0; i < students.length; i++) {
            try {
                if (students[i].getLastName().equals(lastname)) {
                    return students[i];
                }
            } catch (NullPointerException e) {
            }
        }
        throw  new StudentNotFoundException();
    }

    public boolean deleteStudentById(int id){
        for (int i = 0; i < students.length; i++) {
            try {
                if (students[i].getId()==id) {
                    students[i]=null;
                    return true;
                }
            }catch (NullPointerException e) {
            }
        }
        return false;
    }

    public void sortStudents(){
        Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }


    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
