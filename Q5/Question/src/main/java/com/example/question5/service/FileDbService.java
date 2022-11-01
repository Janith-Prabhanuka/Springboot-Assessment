package com.example.question5.service;

import com.example.question5.model.FileDb;
import com.example.question5.repository.FileDbRepository;
import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileDbService {

  @Autowired
  private FileDbRepository fileDbRepository;

  public FileDb store(MultipartFile file) throws IOException {
    FileDb fileDb = new FileDb();
    fileDb.setId(UUID.randomUUID().toString());
    fileDb.setName(file.getOriginalFilename());
    fileDb.setType(file.getContentType());
    fileDb.setUploadImageData(file.getBytes());
    return fileDbRepository.save(fileDb);
  }
}
