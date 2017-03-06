package reynoldstitko.gillian.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reynoldstitko.gillian.Dao.StudentDao;
import reynoldstitko.gillian.Entity.Student;

import java.util.Collection;

/**
 * Created by gillianreynolds-titko on 3/5/17.
 */

//The Service Layer talks to the DAO layer
@Service
public class StudentService {

    //Create an instance of the DAO (Data access). This is the service that uses the database
    //Since we now have two versions of the StudentDao (one for fake dat and one for
    //NySQL data, we need to use a qualifier to help Spring determine which to use

    @Autowired
    @Qualifier("mysqlData") //can now switch between fakeData and mySQl data using the qualifier
    //If we run Postman or the localhost, we will get the data associated with this database
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    //Could do logic here to check if the student exists and if not, could return http code that data is not available
    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }

    //Could do logic here to check if the student exists and if not, could return http code that data is not available
    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    //UPDATE
    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudentToDb(student);
    }
}
