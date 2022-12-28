package ru.edu.bsu.spring.abduvaliev.work4;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Random;
@RestController
public class Custom {
    public static final Map<String, Student> STUDENTS = Map.of(
            "StudentTrue", new Custom.Student(true, true, true, true),
            "StudentFalse", new Custom.Student(false, false, false, false),
            "StudentFalse2", new Custom.Student(false, false, false, false)
    );
    @PreAuthorize("@securityService.passTestIn4thCourse(#studentName)")
    @GetMapping("/tests/{studentName}")
    public StudentDto customSecurity(@PathVariable String studentName) {
        return new StudentDto(studentName, STUDENTS.get(studentName));
    }
    @Data
    @AllArgsConstructor
    static class Student {
        private final boolean work1;
        private final boolean work2;
        private final boolean work3;
        private final boolean work4;
        public Student(Random random) {
            this.work1 = random.nextBoolean();
            this.work2 = random.nextBoolean();
            this.work3 = random.nextBoolean();
            this.work4 = random.nextBoolean();
        }
        private String getResult(boolean b) {
            return b ? "Passed" : "Didn't pass";
        }
        public String getResult() {
            return this.getResult(work1 && work2 && work3 && work4);
        }
        public String work1() {
            return this.getResult(work1);
        }
        public String work2() {
            return this.getResult(work2);
        }
        public String work3() {
            return this.getResult(work3);
        }
        public String work4() {
            return this.getResult(work4);
        }
    }
    @Data
    static class StudentDto {
        private final String studentName;
        private final String work1;
        private final String work2;
        private final String work3;
        private final String work4;
        private final String result;
        public StudentDto(String studentName, Student student) {
            this.studentName = studentName;
            this.work1 = student.work1();
            this.work2 = student.work2();
            this.work3 = student.work3();
            this.work4 = student.work4();
            this.result = student.getResult();
        }
    }
}

