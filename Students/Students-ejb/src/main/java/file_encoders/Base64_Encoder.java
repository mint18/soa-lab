package file_encoders;

import io.undertow.util.FileUtils;
import org.jboss.ws.api.annotation.WebContext;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.*;
import java.util.Base64;

@Stateless
@WebService
@WebContext(urlPattern = "file")
public class Base64_Encoder {
    @WebMethod
    @WebResult
    public String Send(@WebParam(name = "path") String path){
        File file = new File(path);
        String encodedFile = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);
        }catch(FileNotFoundException e){
            encodedFile = "File not found";
        }catch (IOException e) {
            encodedFile = "Error";
        }
        return encodedFile;
    }

    @WebMethod
    public byte[] getByte(@WebParam(name = "path") String path) {
        byte[] getBytes = {};
        try {
            File file = new File(path);
            getBytes = new byte[(int) file.length()];
            InputStream is = new FileInputStream(file);
            is.read(getBytes);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getBytes;
    }
}