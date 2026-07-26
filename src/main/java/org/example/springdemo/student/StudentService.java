package org.example.springdemo.student;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    private int nextId = 4;

    public StudentService() {
        students.add(new Student(1, "Sarin", 90.5));
        students.add(new Student(2, "Sinak", 40.9));
        students.add(new Student(3, "Rotha", 89.9));
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return students;
    }

    // READ ONE
    public Student getStudentById(Integer id) {

        for (Student student : students) {

            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    // CREATE
    public Student createStudent(Student student) {
        student.setId(nextId);
        nextId++;
        students.add(student);
        return student;
    }
    public  Student updateStudent(
            Integer id ,
            Student newStudentData
    ){
        // Find the existing student
        Student existingStudent = getStudentById(id);
        // Student does not exist
        if(existingStudent == null){
            return  null;
        }
        // copy new values into the existing student
        existingStudent.setName(newStudentData.getName());
        existingStudent.setScore(newStudentData.getScore());
        return existingStudent;
    }
    // Delete
    public  boolean deleteStudent (Integer id){
        Student student = getStudentById(id);
        if(student == null){
            return false;
        }
        students.remove(student);
        return  true;
    }
}