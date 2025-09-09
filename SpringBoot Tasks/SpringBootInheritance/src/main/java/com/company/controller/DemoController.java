package com.company.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.controller.dto.StudentDTO;
import com.company.controller.dto.Student_DTO;
import com.company.controller.dto.TeacherDTO;
import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.entity.base.Address;
import com.company.entity.base.Person;
import com.company.repo.PersonRepo;
import com.company.repo.TeacherRepo;
import com.company.service.StudentService;
import com.company.service.TeacherService;

@RestController
@RequestMapping("/api") // Base URL for all endpoints
public class DemoController {

    // Services and Repositories injected
    private final StudentService studentService;
    private final TeacherRepo teacherRepo;
    private final PersonRepo personRepo;
    private final TeacherService teacherService;

    // Constructor-based dependency injection
    public DemoController(StudentService studentService, TeacherRepo teacherRepo,
                          PersonRepo personRepo, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherRepo = teacherRepo;
        this.personRepo = personRepo;
        this.teacherService = teacherService;
    }


    // POST endpoint to add sample data: 1 Teacher + 2 Students
 
    @PostMapping("/add")
    public String add() {

        // Create Teacher
        Teacher t1 = new Teacher("Rasi", new Address("RS", "Rasipuram", "637408"), "IT");
        teacherRepo.save(t1);

        // Create Student 1
        Student s1 = new Student("Gowsi", new Address("GK", "Salem", "637409"));
        s1.addEmail("abc@gmail.com");
        s1.addEmail("xyz@Yahoo.co.in");

        // Create Student 2
        Student s2 = new Student("Sanjai", new Address("SK", "Namakkal", "637401"));
        s2.addEmail("fgh@gmail.com");
        s2.addEmail("klo@Yahoo.co.in");

        // Save Students
        studentService.save(s1);
        studentService.save(s2);

        return "Records Added Successfully!";
    }

   
    // GET endpoint to retrieve all students as DTO
   
    @GetMapping("/studentsdata")
    public List<StudentDTO> getAllStudents() {
        return studentService.findAllWithEmails().stream()
                .map(s -> new StudentDTO(
                        s.getId(),
                        s.getName(),
                        s.getAddress().getCity(),
                        s.getEmails().stream().map(e -> e.getEmail()).toList()
                ))
                .collect(Collectors.toList());
    }

   
    // GET endpoint to retrieve all people (Students + Teachers)
    
    @GetMapping("/people")
    public List<String> getAllPeople() {
        List<Person> people = personRepo.findAll();

        return people.stream().map(p -> {
            if (p instanceof Student s)
                return "Student: " + s.getName() + ", City: " + s.getAddress().getCity();
            else if (p instanceof Teacher t)
                return "Teacher: " + t.getName() + ", Subject: " + t.getSubject();
            else
                return "Unknown Person Type";
        }).toList();
    }

    
    // GET endpoint to retrieve all students
   
    @GetMapping("/students")
    public List<String> getStudentNames() {
        return personRepo.findAllStudents()
                .stream()
                .map(Student::getName)
                .toList();
    }

    
    // GET endpoint to retrieve all teachers
    
    @GetMapping("/teachers")
    public List<String> getTeacherNames() {
        return teacherRepo.findAllTeachers()
                .stream()
                .map(Teacher::getName)
                .toList();
    }

  
    // GET endpoint to retrieve all students as custom DTO
   
    @GetMapping("/students_dto")
    public List<Student_DTO> getStudentsDTO() {
        return studentService.allStudents_DTO();
    }

 
    // GET endpoint to retrieve all teachers as custom DTO
    
    @GetMapping("/teachersdata")
    public List<TeacherDTO.TeacherRecord> getTeachersDTO() {
        return teacherService.getAllTeacherDTOs();
    }

 
    // GET endpoint to retrieve all teachers with details
  
    @GetMapping("/allteachers")
    public List<String> printAllTeachers() {
        return teacherRepo.findAllTeachers()
                .stream()
                .map(t -> "Teacher Name: " + t.getName() + ", Subject: " + t.getSubject())
                .toList();
    }
}
