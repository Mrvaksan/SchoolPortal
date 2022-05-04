package com.app.schoolportal.logic;

public class Portal {
    private static School currentSchool = new School();
    private static Student currentStudent;

    public static School getCurrentSchool() {
        return currentSchool;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static void setCurrentStudent(Student currentStudent) {
        Portal.currentStudent = currentStudent;
    }
}
