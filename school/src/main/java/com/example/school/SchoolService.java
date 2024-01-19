package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient client;
    public void saveSchool (School school){ repository.save(school);}

    public List<School> findAllschools(){ return repository.findAll();}

    public FullSchoolResponse findAllschoolsWithStudents(Integer schoolId){
        var school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students= client.findAllStudentsBySchool(schoolId);//find all the students from the student micro service
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
    public School findstudentwithschool(Integer studentId){
        return repository.findByStudentId(studentId);
    }
}

