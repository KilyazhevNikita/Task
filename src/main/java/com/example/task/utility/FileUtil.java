package com.example.task.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {

    private FileUtil() {
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        try (FileOutputStream out = new FileOutputStream(filePath + fileName)) {
            out.write(file);
            out.flush();
        }
    }

    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getFileName(String fileOriginName) {
        return getUUID() + getSuffix(fileOriginName);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
