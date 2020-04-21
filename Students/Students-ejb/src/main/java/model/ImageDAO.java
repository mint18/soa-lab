package model;

import javax.ejb.Singleton;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ImageDAO {

    private final String IMAGE_PATH = "C:\\Users\\mateo\\Desktop\\image.jpg";
    private static final Map<Integer, String> imagesMap = new HashMap<>();

    public String getImagePath(Integer studentId) {
        if (imagesMap.containsKey(studentId)) {
            return imagesMap.get(studentId);
        }
        return IMAGE_PATH;
    }

    public void addImage(Integer studentId, byte[] image) throws IOException {
        String fileName = "C:\\Users\\mateo\\Desktop\\image" + studentId + ".jpg";
        saveImage(fileName, image);
        imagesMap.put(studentId, fileName);
    }

    private void saveImage(String fileName, byte[] image) throws IOException {
        File newFile;
        FileOutputStream outputStream;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            newFile = new File(fileName);
            outputStream = new FileOutputStream(newFile);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] fileBytes = image;
            System.out.println(fileBytes);
            bufferedOutputStream.write(fileBytes);

        } catch (IOException e) {
            throw e;
        } finally {
            if (bufferedOutputStream != null)
                bufferedOutputStream.close();
        }
    }

}
