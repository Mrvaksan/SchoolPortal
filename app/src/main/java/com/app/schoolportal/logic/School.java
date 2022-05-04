package com.app.schoolportal.logic;

public class School {
    private Teacher[] teachersList = new Teacher[5];
    private Student[] studentsList = new Student[5];
    private Courses[] courseList = new Courses[5];
    private int studentCount = 0;
    private int teacherCount = 0;
    private int courseCount = 0;

    public School() {
        //Öğretmenleri ekleyelim
        teachersList[teacherCount++]=new Teacher("J. Cole",12345,"0000",0);
        teachersList[teacherCount++]=new Teacher("K. Harvey",54321,"1453",1);
        teachersList[teacherCount++]=new Teacher("S. Adam",11111,"1517",2);

        //Dersleri ekleyelim
        courseList[courseCount++]=new Courses(0,7,"MATH");
        courseList[courseCount++]=new Courses(1,6,"PHYSIC");
        courseList[courseCount++]=new Courses(2,3,"MUSIC");

        //Öğrencileri ekleyelim
        studentsList[studentCount++]=new Student("M.","Hunter",11111,"1234",courseList);
        studentsList[studentCount++]=new Student("G.","Chris",22222,"1111",courseList);
        studentsList[studentCount++]=new Student("D.","Santos",33333,"4321",courseList);
    }

    public Student getStudentByCredentials(int id, String password){
        for (int i = 0; i < studentCount; i++) {
            if (id == studentsList[i].s_id && password.equals(studentsList[i].s_password)) {
                return studentsList[i];
            }
        }

        return null;
    }


}
