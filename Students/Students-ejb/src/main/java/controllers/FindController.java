package controllers;

import model.Course;
import model.Student;
import model.StudentDAO;
import org.jboss.ws.api.annotation.WebContext;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@WebService
@WebContext(urlPattern = "find")
@Stateless
public class FindController {

    @Inject
    private StudentDAO studentDAO;

    @WebMethod
    public List<Student> getStudents(){
        return studentDAO.getStudents();
    }

    @WebMethod
    public List<Course> getCourses(){
        return studentDAO.getCourses();
    }

    public Student findStudentById(@WebParam(name = "id") Integer id) {
        return getStudents().stream()
                .filter(s -> s.id.equals(id))
                .findFirst()
                .get();
    }

    public List<Student> findStudentByName(@WebParam(name = "firstName") String firstName) {
        return studentDAO.findStudents(s -> s.firstName.equals(firstName));
    }

    public List<Student> findStudentByLastName(@WebParam(name = "") String lastName) {
        return studentDAO.findStudents(s -> s.lastName.equals(lastName));
    }

    public List<Student> findStudentByAge(@WebParam(name = "age") Integer age) {
        return studentDAO.findStudents(s -> s.age.equals(age));
    }

    public List<Student> findStudentByYearOfStudy(@WebParam(name = "yearOfStudy") Integer yearOfStudy) {
        return studentDAO.findStudents(s -> s.yearOfStudy.equals(yearOfStudy));
    }

    public List<Student> findStudentByField(@WebParam(name = "field") String field) {
        return studentDAO.findStudents(s -> s.field.equals(field));
    }

    public List<Student> findStudentByCourseID(@WebParam(name = "course_id") Integer course_id) {
        return getStudents().stream()
                .filter(s -> s.containsCourseID(course_id))
                .collect(Collectors.toList());
    }

    public List<Student> findStudentByCourseName(@WebParam(name = "course_name") String course_name) {
        return getStudents().stream()
                .filter(s -> s.containsCourseName(course_name))
                .collect(Collectors.toList());
    }
}
