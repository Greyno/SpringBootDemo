package reynoldstitko.gillian.Dao;

import reynoldstitko.gillian.Entity.Student;

import java.util.Collection;

/**
 * Created by gillianreynolds-titko on 3/5/17.
 */
public interface StudentDao {
    //Create a way to get information
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDb(Student student);
}
