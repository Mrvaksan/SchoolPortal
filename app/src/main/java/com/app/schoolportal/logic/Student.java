package com.app.schoolportal.logic;

import java.util.Locale;

public class Student {
    String s_name;
    String s_surname;
    int s_id;
    String s_password;
    int[] grades = new int[5];
    int[] nonattendances = new int[5];
    Courses[] courseList = new Courses[5];
    int nonAttendances;
    int akts;
    int weightedTotals;
    double gpa;

    public Student(String s_name, String s_surname, int s_id, String s_password, Courses[] courseList) {
        this.s_name = s_name;
        this.s_surname = s_surname;
        this.s_id = s_id;
        this.s_password = s_password;
        this.courseList = courseList;
    }

    public void setGrade(int grade, int t_branch) {
        grades[t_branch] = grade;
    }

    public void setNonAttendance(int nonattendance, int t_branch) {
        nonattendances[t_branch] = nonattendance;
    }

    public String generateTranscript() {
        String result = "";

        result += String.format("%-15s%15s\n", "İSİM:", s_name);
        result += String.format("%-15s%15s\n", "SOYİSİM:", s_surname);
        result += String.format(Locale.ENGLISH, "%-15s%15d\n", "OKUL NUMARASI:", s_id);
        result += ("____________NOTLAR____________\n");
        result += String.format("%-10s%10s%10s\n", "DERS ADI", "AKTS", "ORTALAMA");

        for (int i = 0; i < grades.length; i++) {
            if (courseList[i] != null) {
                result += String.format(Locale.ENGLISH, "%-10s%10d%10d\n", courseList[i].c_name, courseList[i].c_weight, grades[i]);
            }
        }
        result += ("______________________________\n");
        nonAttendances = 0;
        for (int i = 0; i < nonattendances.length; i++) {
            nonAttendances += nonattendances[i];
        }
        result += String.format(Locale.ENGLISH, "%-15s%15d\n", "DEVAMSIZLIK", nonAttendances);
        result += ("______________________________\n");

        akts = 0;
        weightedTotals = 0;
        for (int i = 0; i < courseList.length; i++) {
            if (courseList[i] != null) {
                akts += courseList[i].c_weight;
                weightedTotals += courseList[i].c_weight * grades[i];
            }
        }
        gpa = weightedTotals / akts;
        result += String.format(Locale.ENGLISH, "%-15s%15.2f\n", "GENEL ORTALAMA:", gpa);

        return result;
    }
}
