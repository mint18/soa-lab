package controllers;


import model.Student;
import model.StudentDAO;
import org.jboss.ws.api.annotation.WebContext;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@WebContext(urlPattern = "update")
@Stateless
public class UpdateController {

    @Inject
    private StudentDAO studentDAO;

    @WebMethod
    public String updateStudent(@WebParam(name = "updatedStudent_id") Integer id, @WebParam(name = "firstName") String firstName,
                                @WebParam(name = "lastName") String lastName, @WebParam(name = "age") Integer age,
                                @WebParam(name = "yearOfStudy") Integer yearOfStudy, @WebParam(name = "field") String field){
        studentDAO.updateStudent(new Student(id, firstName, lastName, age, yearOfStudy, field, studentDAO.getCourses()));
        return "Succesfully Updated";
    }
}
