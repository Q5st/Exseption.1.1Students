package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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
            if(students[i]!=null) {
                if (students[i].getLastName().equals(lastname)) {
                    return students[i];
                }
            }
        }
        throw  new StudentNotFoundException();
    }

    public boolean deleteStudentById(int id){
        for (int i = 0; i < students.length; i++) {
            if(students[i]!=null) {
                if (students[i].getId()==id) {
                    students[i]=null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean noSameStudents(){
        for(int i=0; i<students.length-1; i++){
            for (int j=i+1; j<students.length; j++){
                if (students[i].equals(students[j])){
                    return false;
                }
            }
        }
        return true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(groupName);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}
