package com.example.student;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name ="school-service", url="${application.config.schools-url}")
public interface SchoolClient {
    @GetMapping("/student/{student-id}")
    School finSchoolByStudent(@PathVariable("student-id") Integer studentId);
}
