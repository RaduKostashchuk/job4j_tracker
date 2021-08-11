package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Костащук Раду Михайлович");
        student.setGroup("Стажер");
        student.setAdmission("30.07.21");
        System.out.println(student.getFio());
        System.out.println(student.getGroup());
        System.out.println(student.getAdmission());
    }
}
