package com.jm.restapi.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
public class StudentController {
    @Autowired
    StudentRepository repo;
//    get all the students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
            return students;
    }

//    getting student by id
    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;

    }
//    adding a new student
    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }
//    updating student
    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id){
       Student student = repo.findById(id).get();
       student.setName("poonam");
       student.setPercentage(92);
       repo.save(student);
       return student;
    }

//    deleting student
    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
            repo.delete(student);
    }
}
