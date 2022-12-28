package ru.edu.bsu.spring.abduvaliev.work4;

import org.springframework.stereotype.Service;
import java.util.List;
@Service("Service")
public class ServiceTest {
    private static final List<String> studentsIn4thCourse = List.of(
            "studentTrue", "studentFalse2");
    public boolean passTestIn4thCourse(String studentName) {
        return studentsIn4thCourse.contains(studentName);
    }
}
