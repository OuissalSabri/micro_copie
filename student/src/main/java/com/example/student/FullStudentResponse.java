package com.example.student;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullStudentResponse {
    private String firstname;
    private String lastname;
    private String email;
    private School school;
}
