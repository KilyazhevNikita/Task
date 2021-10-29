package com.example.task.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String uploadFile(MultipartFile file);
}
