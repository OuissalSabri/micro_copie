package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        service.saveSchool(school);
    }
@GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(service.findAllschools());
}

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools( @PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(service.findAllschoolsWithStudents(schoolId));
    }

    @GetMapping("/student/{student-id}")
    public ResponseEntity<School> findAllSchool(@PathVariable("student-id") Integer studentId){

        return ResponseEntity.ok(service.findstudentwithschool(studentId));
    }

}
