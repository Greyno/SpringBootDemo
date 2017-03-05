package reynoldstitko.gillian.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reynoldstitko.gillian.Dao.FakeStudentDaoImplementation;
import reynoldstitko.gillian.Entity.Student;

import java.util.Collection;

/**
 * Created by gillianreynolds-titko on 3/5/17.
 */

//The Service Layer talks to the DAO layer
@Service
public class StudentService {

    //Create an instance of the DAO. This is the service that uses the database
    @Autowired
    private FakeStudentDaoImplementation fakeStudentDaoImplementation;

    public Collection<Student> getAllStudents(){
        return this.fakeStudentDaoImplementation.getAllStudents();
    }

    //Could do logic here to check if the student exists and if not, could return http code that data is not available
    public Student getStudentById(int id){
        return this.fakeStudentDaoImplementation.getStudentById(id);
    }

    //Could do logic here to check if the student exists and if not, could return http code that data is not available
    public void removeStudentById(int id) {
        this.fakeStudentDaoImplementation.removeStudentById(id);
    }

    //UPDATE
    public void updateStudent(Student student){
        this.fakeStudentDaoImplementation.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.fakeStudentDaoImplementation.insertStudentToDb(student);
    }
}
