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
@WebContext(urlPattern = "remove")
@Stateless
public class RemoveController {

    @Inject
    private StudentDAO studentDAO;

    @WebMethod
    public String removeStudent(@WebParam(name = "id") Integer id){
        studentDAO.removeStudent(id);
        return "Student has been removed";
    }
}
