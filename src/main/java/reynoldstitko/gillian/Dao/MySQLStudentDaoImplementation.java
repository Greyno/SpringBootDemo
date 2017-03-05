package reynoldstitko.gillian.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import reynoldstitko.gillian.Entity.Student;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by gillianreynolds-titko on 3/5/17.
 */

@Repository
@Qualifier("mysqlData")
public class MySQLStudentDaoImplementation implements StudentDao {

    //Create a connection to a MySQL dbase here

    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>() {
            {

                add(new Student(1, "Mario", "Maths"));
            }
        };
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudentToDb(Student student) {

    }
}
