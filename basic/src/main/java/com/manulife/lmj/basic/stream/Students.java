package com.manulife.lmj.basic.stream;

public class Students {
    private int grade;
    private int classroom;

    public Students(int grade, int classroom, String name, String number, float chinese, float math, float english) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.number = number;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    @Override
    public String toString() {
        return "Students{" +
                "grade=" + grade +
                ", classroom=" + classroom +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    private String name;
    private String number;
    private float chinese;
    private float math;
    private float english;

    public Students() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        this.chinese = chinese;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone called");
        return new Students(this.getGrade(), this.getClassroom(), this.getName(), this.getNumber(), this.getChinese(), this.getMath(), this.getEnglish());
    }
}
