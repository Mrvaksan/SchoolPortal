package com.app.schoolportal.logic;

public class Portal {
    private static School currentSchool = new School();
    private static Student currentStudent;
    private static Teacher currentTeacher;

    public static School getCurrentSchool() {
        return currentSchool;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static Teacher getCurrentTeacher() { return currentTeacher; }

    public static void setCurrentStudent(Student currentStudent) {
        Portal.currentStudent = currentStudent;
    }

    public static void setCurrentTeacher(Teacher currentTeacher) {
        Portal.currentTeacher = currentTeacher;
    }
}
