package reynoldstitko.gillian.Dao;

import org.springframework.stereotype.Repository;
import reynoldstitko.gillian.Entity.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gillianreynolds-titko on 2/21/17.
 */

//The Dao is the data layer
@Repository //tells the SpringBoot bean that this is a repository
public class StudentDao {

//From https://www.youtube.com/watch?v=Ke7Tr4RgRTs

    //The DAO is a class that will give us data from any database we want
    //Implement CRUD (create, read, update, delete)

    //Work with some fake data initially - this is our database
    private static Map<Integer, Student> students;
    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Said", "Computer Science"));
                put(2, new Student(2, "Alex U", "Finance"));
                put(3, new Student(3, "Anna", "Maths"));
            }
        };
    }

    //Create a way to get information
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());

        students.put(student.getId(), student);
    }

    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(), student);
    }
}

