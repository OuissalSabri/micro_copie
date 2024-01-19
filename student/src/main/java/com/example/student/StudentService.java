package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final SchoolClient client;
    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId){
        return repository.findAllBySchoolId(schoolId);
    }

    public FullStudentResponse findschoolsWithStudent(Integer studentId){
        var student = repository.findById(studentId)
                .orElse(
                        Student.builder()
                                .firstname("NOT_FOUND")
                                .lastname("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var school= client.finSchoolByStudent(studentId);//find student from the school micro service
        return FullStudentResponse.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .email(student.getEmail())
                .school(school)
                .build();
    }

}
