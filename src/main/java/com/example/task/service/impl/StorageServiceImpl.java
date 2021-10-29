package com.example.task.service.impl;

import com.example.task.exception.FileException;
import com.example.task.service.StorageService;
import com.example.task.utility.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {

    @Value("${storage}")
    private String filePath;

    @Override
    public String uploadFile(MultipartFile file) {
        String fileName = FileUtil.getFileName(file.getOriginalFilename());
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            throw new FileException("failed to load file");
        }
        return fileName;
    }
}
