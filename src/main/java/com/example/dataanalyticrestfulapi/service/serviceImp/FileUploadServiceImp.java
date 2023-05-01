package com.example.dataanalyticrestfulapi.service.serviceImp;

import com.example.dataanalyticrestfulapi.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
@Service
public class FileUploadServiceImp implements FileUploadService {
    Path fileLocationStorage;

    FileUploadServiceImp() {
        fileLocationStorage = Paths.get("src/main/resources/image");
    }
    @Override
    public String Image(String path, MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        if (filename != null) {
            // condition for filename
            if (filename.contains("..")) {
                System.out.println("Filename is incorrect !! ");
                return null;
            }
            String[] fileParts = filename.split("\\.");
            filename = UUID.randomUUID() +"." + fileParts[1];
            // asdlfkasfd-asdfkasdjflasd-sdkfj.png
            //resolved path

            Path resolvedPath = fileLocationStorage.resolve(filename);
            Files.copy(file.getInputStream(), resolvedPath, StandardCopyOption.REPLACE_EXISTING);
            return filename;

        }else return null ;
    }
    }

