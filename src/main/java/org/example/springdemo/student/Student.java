package org.example.springdemo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Students represent the structure of student data

public class Student {
    private Integer id;
    private String name ;
    private Double score;
    // why use constructor
    // The constructor allows us to create a student object


}
//@RestController   // receives HTTP requests
//@RequestMapping   // defines the main URL
//@GetMapping       // receives GET requests
//@Service          // contains logic and is managed by Spring