package controllers;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.StudentDAO;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;


@Stateless
@WebService
@SecurityDomain("new-domain")
@DeclareRoles({"developer"})
@WebContext(urlPattern = "add",authMethod = "BASIC",transportGuarantee = "NONE", secureWSDLAccess=false )
public class AddController {

    @Inject
    private StudentDAO studentDAO;

    @RolesAllowed("developer")
    @WebMethod
    public String addStudent(@WebParam(name = "id") Integer id, @WebParam(name = "firstName") String firstName,
                            @WebParam(name = "lastName") String lastName, @WebParam(name = "age") Integer age,
                            @WebParam(name ="yearOfStudy") Integer yearOfStudy, @WebParam(name = "field") String field){
        Student student = new Student(id, firstName, lastName, age, yearOfStudy, field, studentDAO.getCourses());
        studentDAO.addStudent(student);
        return String.format("Added %s", student);
    }

}
