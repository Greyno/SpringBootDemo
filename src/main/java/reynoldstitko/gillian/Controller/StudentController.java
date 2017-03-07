package reynoldstitko.gillian.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reynoldstitko.gillian.Entity.Student;
import reynoldstitko.gillian.Service.StudentService;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Collection;

/**
 * Created by gillianreynolds-titko on 3/5/17.
 */

//The Controller layer talks to the Service Layer
@RestController
@RequestMapping("/students") //Need a URL or endpoint; we'll define the pattern for the endpoint
public class StudentController {

    //The controller offloads the request to Student Service

    //We will implement CRUD in the Controller layer (Create, Read, Update, Delete)

    //Using @Autowired, SpringBoot will look for a bean of type StudentService and will instantiate and inject a new
    // instance. We use dependency injection on our beans. That way we don't need to use the 'new' keyword and can
    // have a flexible, decoupled system

    @Autowired
    private StudentService studentService; //use ctrl-space to get an instance of the StudentService

    //the item below is a Get request. We could also have said @RequestMapping(value = "/", method = RequestMethod.GET)
    //where "/" defines the endpoint, but once we get to "students" this will be the method that will be triggered

    //READ items in the database using GET
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Create a mapping to capture the id; use @PathVariable to gather the id from the URL
    //We have created another endpoint
    //In the browser, use http://localhost:8080/students/3 to get the student with the id value of 3

    //READ items in the database using GET
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }


    //To DELETE in Postman, select Delete and select the student by using localhost:8080/students/id# and
    //then SEND. You can use a GET to see the new list of students, less the deleted item (use localhost:8080/students)

    //To remove (DELETE) an item from the database using DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }

    //To test update (PUT) in Postman, use PUT, Body > raw (JSON application/json) and put in the JSON
    //that needs to be updated and Send. Use @RequestBody to read the request that is sent back
    //On localhost:8080, will be able to see the value that was replaced
    //Use consumes in case there is an error, we let the system know that we are looking at JSON type data

    //To update (UPDATE) a student in the database using PUT
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }


    //To test Create (POST) in Postman, use Post, Body > raw (JSON application/json) and put the new
    //student information in as JSON format and Send. Will be able to see changes on localhost:808. Also,
    //in Postman, can GET to see a list of all the students now in the database

    //Insert (CREATE) a new student into the database using POST
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }



}
