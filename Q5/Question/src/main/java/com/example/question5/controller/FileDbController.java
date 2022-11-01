package com.example.question5.controller;

import com.example.question5.service.FileDbService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileDbController {

  @Autowired
  private FileDbService fileDbService;

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

    String pathDirectory = "C:\\Users\\Janith_105915\\Documents";
    Files.copy(file.getInputStream(), Paths.get(pathDirectory + File.separator + file.getOriginalFilename()),
        StandardCopyOption.REPLACE_EXISTING);

    fileDbService.store(file);

    return "Successfully image is uploaded";
  }
}
