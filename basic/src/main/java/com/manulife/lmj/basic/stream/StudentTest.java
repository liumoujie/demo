package com.manulife.lmj.basic.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentTest {

    public static void main(String[] args) {
//        generateStudents().forEach(students -> System.out.println(students));
        generateStudents()
                .stream().filter(students -> students.getGrade() == 6 && students.getClassroom() == 2).forEach(students -> System.out.println(students));
//        System.out.println(generateStudents()
//                .stream().filter(students -> students.getGrade() == 6 && students.getClassroom() == 2).collect(Collectors.toList()).stream().reduce(new Students(), (a, b) -> {
//                    System.out.println(b);
//                    a.setMath(a.getMath() + b.getMath());
//                    return a;
//                }).getMath());
//        System.out.println(generateStudents()
//                .stream().filter(students -> students.getGrade() == 6 && students.getClassroom() == 2).reduce(new Students(), (a, b) -> {
//                    System.out.println(b);
//                    a.setMath(a.getMath() + b.getMath());
//                    return a;
//                }).getMath()
//        );
//        avgMath(6, 2);


        System.out.println(generateStudents()
                .stream().filter(students -> students.getGrade() == 6 && students.getClassroom() == 2).map(students -> students.getMath()).reduce((a, b) -> a + b).get());
    }

    private static void avgMath(int grade, int classroom) {
        System.out.println(generateStudents().stream().filter(students -> students.getGrade() == grade && students.getClassroom() == classroom).count());
        System.out.println(generateStudents().stream().
                filter(students -> students.getGrade() == grade && students.getClassroom() == classroom).
                collect(Collectors.summingDouble(Students::getMath)));
        System.out.println(generateStudents().stream().
                filter(students -> students.getGrade() == grade && students.getClassroom() == classroom).
                collect(Collectors.averagingDouble(Students::getMath)).doubleValue());
    }

    private static List<Students> generateStudents() {
        List<Students> studentsList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {

            Random random = new Random();
            float scoreChinese = random.nextFloat() * 100;
            float scoreMath = random.nextFloat() * 100;
            float scoreEnglish = random.nextFloat() * 100;
            studentsList.add(new Students(6, 2, ("Grade-" + i % 6 + 1 + "Class-" + i % 2 + 1), String.valueOf(i), scoreChinese, scoreMath, scoreEnglish));
        }
//        studentsList.add(new Students(6, 2, "Grade-6-Class-2", "5", 1.2f, 1.3f, 1.4f));
//        studentsList.add(new Students(6, 2, "Grade-6-Class-2", "6", 2.2f, 2.3f, 2.4f));
//        studentsList.add(new Students(5, 2, "Grade-6-Class-2", "7", 3.2f, 3.3f, 3.4f));
//        studentsList.add(new Students(5, 2, "Grade-6-Class-2", "8", 4.2f, 4.3f, 4.4f));
//        studentsList.add(new Students(5, 2, "Grade-6-Class-2", "9", 5.2f, 5.3f, 5.4f));
        return studentsList;
    }
}
