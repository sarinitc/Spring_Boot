package org.example.springdemo.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;
// What does @Rescontroller do ?
// It tells Spring this class receives HTTP request and send response data.
// Example GET/students
@RestController
// What does @Getmapping do ?
// It defines the main URL for this controller
// Example /students
@RequestMapping("/All/students")
public class StudentController {
    // why does the controller need the service
    // The controller should not create and manage all student data by itself.
    // Instead , it asks the service
    // Controller : Give me all students
    // Service : Here is the student list.
    private  final  StudentService studentService;


    // What is this constructor doing ?
    //Spring finds the StudentService bean and passes it into the controller.
    // This is call constructor dependency injection.
    // This flow is
    // Spring creates StudentService ---> Spring creates StudentController ---> Spring passes StudentService into StudentController
    public  StudentController (StudentService studentService){
        this.studentService=studentService;
    }

// What does @GetMapping do ?
    // It means this method handles an HTTP GET Request
    //
    @GetMapping
    // What happens in this method ?
    // A GET/student request arrives
    // Spring calls getAllStudent() in the controller
    // The controller calls studentService().getAllStudents();
    // The service returns the student list.
    // The controller returns that list
    // Spring converts the java list into JSON.
    // Swagger or the browser display the JSON.
    public List<Student> getAllStudents(){
        return  studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    // what is ResponseEntity ?
    // ResponseEntity lets use control
    // The response data
    // The HTTP status code

    public ResponseEntity<Student> getStudentById(
            @PathVariable Integer id
    ){
        // Call the service
        Student student = studentService.getStudentById(id);
        if(student== null){
            return ResponseEntity.notFound().build();

        }
        return  ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student
    ) {
        Student createdStudent =
                studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Student> updateStudent(
            // This gets the id from the URL
            @PathVariable Integer id,
            // Get the new information from the JSON request body
            @RequestBody Student student
    ){

        // why call the service ?
        // The controller should not search and update the list itself.
        // Receive request and Take request values and Call service and return response

        // The Service responsibility ?
        // Search student
        // Check student exists
        // Change student data
        // Return result

        // Call the service
        // This is one statement written on two lines
        // It can also be written as : Student updateStudent = studentService.updateStudent(id, student);
        Student updateStudent =
                studentService.updateStudent(id, student);
        if(updateStudent == null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(updateStudent);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteStudent(
            @PathVariable Integer id

    ){
        boolean deleted = studentService.deleteStudent(id);
        if(!deleted){
            return  ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student not found");

        }
        return ResponseEntity.ok(
                "Student deleted successfully"
        );
    }

}