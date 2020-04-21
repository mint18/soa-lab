package controllers;

import model.ImageDAO;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;


@WebService
@DeclareRoles({"developer"})
@SecurityDomain("new-domain")
@WebContext(urlPattern = "image", authMethod = "BASIC",transportGuarantee = "NONE")
@Stateless
public class ImageController {

    @Inject
    ImageDAO imageDAO;

    @WebMethod
    @RolesAllowed("developer")
    public String uploadImage(@WebParam(name = "studentId") Integer studentId, @WebParam(name = "image") byte[] image) {
        //String encodedFile = null;
        try {
            imageDAO.addImage(studentId, image);
            return "Image added";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @WebMethod
    @RolesAllowed("developer")
    public byte[] downloadImage(@WebParam(name = "studentId") Integer studentId) {
        String filePath = imageDAO.getImagePath(studentId);
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            bufferedInputStream.read(fileBytes);
            bufferedInputStream.close();
            return fileBytes;
        } catch (IOException ex) {
            throw new WebServiceException(ex);
        }
    }

}
