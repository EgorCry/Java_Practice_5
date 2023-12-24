import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class UploadDownloadService {
    private static final String path = "./files";
    public List<String> uploadFile(MultipartFile file) throws Exception {
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(new File(path, file.getOriginalFilename())));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
        } else {
            throw new Exception();
        }
        List<String> list = new ArrayList<String>();
        File files = new File(path);
        String[] fileList = ((File) files).list();
        for (String name : fileList) {
            list.add(name);

        }
        return list;
    }


    public List<String> getListofFiles() throws Exception {
        List<String> list = new ArrayList<String>();
        File files = new File(path);
        String[] fileList = ((File) files).list();
        for (String name : fileList) {
            list.add(name);
        }
        return list;
    }
}

